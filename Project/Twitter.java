// importing all graph packages from JUNG API 
        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

        import edu.uci.ics.jung.graph.Graph;
        import edu.uci.ics.jung.graph.SparseMultigraph;
        import edu.uci.ics.jung.graph.util.EdgeType;

        import java.util.Collections;
        import java.util.StringTokenizer;
        import java.util.Collection;   // Interface
        import java.util.ArrayList;

        import edu.uci.ics.jung.algorithms.flows.EdmondsKarpMaxFlow;
        import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
        import edu.uci.ics.jung.graph.DirectedGraph;
        import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
        import edu.uci.ics.jung.graph.util.EdgeType;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import org.apache.commons.collections15.Factory;
        import org.apache.commons.collections15.Transformer;




        import edu.uci.ics.jung.algorithms.flows.EdmondsKarpMaxFlow;
        import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
        import edu.uci.ics.jung.graph.DirectedGraph;
        import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
        import edu.uci.ics.jung.graph.util.EdgeType;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import org.apache.commons.collections15.Factory;
        import org.apache.commons.collections15.Transformer;


        

public class Twitter {
    
                static String splitBy = ",";

            public static void main(String[] args) {
                try {
                    // Declaring a graph
                    Graph<Integer, Integer> g;
// storing elements in collection
                    Collection<Integer> p1=new ArrayList<>();
                         //List<Integer>list=
                         Collection<Integer> k=  new ArrayList();
                         Collection<Integer> k2=  new ArrayList();
                         Collection<Integer> k3=  new ArrayList();
                         Collection<Integer> k4=  new ArrayList();
                         Collection<Integer> k5=  new ArrayList();
                  // Allocating memory for a graph 
                    g = new SparseMultigraph<>();
                    
                    // reading dataset from csv files using FileReader
                    FileReader fr = new FileReader("C:\\Users\\saisree\\Desktop\\nodes.csv");
                    FileReader fr1 = new FileReader("C:\\Users\\saisree\\Desktop\\edges.csv");
                    BufferedReader br = new BufferedReader(fr);
                    BufferedReader br1 = new BufferedReader(fr1);
                    String content = br.readLine();
                    String content1 = br1.readLine();

// while content in file not reached end of the file
                    while(content != null){
                        
                    //  converting node1 into string     
                    Integer id1 = Integer.parseInt(content.toString());
                        
                    //  if node1 greater than 1000
                    if(id1>1000)
                                break;
                        content = br.readLine();
                        
                        //  add each vertex from id1 in nodes.csv to graph 
                        g.addVertex((Integer)id1);



                    }


                  int i=0;
                  // while content1 in edges.csv file not equal to null
                    while(content1 != null)
                    {
                        
                       // tokenize two nodes in edges.csv using StringTokenizer
                       StringTokenizer stringTokenizer = new StringTokenizer(content1, ",");
                      // checking for more elements in file or not
                       while (stringTokenizer.hasMoreElements()) {
                           //  converting integer nodes in edges.csv to String
                           
                        Integer id2 = Integer.parseInt(stringTokenizer.nextElement().toString());
                        Integer id3 = Integer.parseInt(stringTokenizer.nextElement().toString());
                        content1 = br1.readLine();
                        
                        //  adding edge between two vertices
                        if(g.containsVertex(id2)&&g.containsVertex(id3)){
                        g.addEdge(++i,id2,id3,EdgeType.DIRECTED);



                       }
                }
// closing file reader 
                    fr.close();
                    
                    // closing BufferedReader if it has no more elements
                    br.close();
                    }

                   // System.out.println(g.toString());
                    
                    // adding vertices to p1 arraylist untill current vertex less than or equal to vertexCount
                    for(int j=0;j<g.getVertexCount();j++)
                    {


                         p1= g.getVertices();
                    }

                    //  finding shortest path between two vertices in a sub graph using Dijkstra's algorithm
                    for(int c = 1;c<=1000;c++)
                    {
                        for(int  d=2;d<=1000;d++)
                        {
                                DijkstraShortestPath<Integer,Integer> alg = new DijkstraShortestPath(g);
   
                                //    adding each object into list l1 after finding shortest path between two nodes
                                
                                List<Integer> l1 = alg.getPath(c, d);
                           // System.out.println("The shortest unweighted path from " + "n" + c + " to " + "n" +d+ " is:");
                           // System.out.println(l1.toString());
                          //  System.out.println(l1.size());
          
                                k3.add(l1.size());
                            }

                        }
                  //hop distance pairs
                    for(int m1=0;m1<k3.size();m1++)
                    {
// adding count of k3 object in collections to k4 oject in anothe collections until size of current oject less than k3 collection
                   k4.add(Collections.frequency(k3, m1));
                    }
                    
                    // printing k4 object in collections to console
                    System.out.println(k4);

                } catch (Exception e) {
                        e.printStackTrace();
                   // System.out.println("An error occurred while reading file using FileReader: " + e.getMessage());
                }
            }


                }
                