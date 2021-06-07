import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyGraph {
    ArrayList<Vertex> vertices;

    public AdjacencyGraph(){
        vertices=new ArrayList<Vertex>();       // initiere konstruktor
    }

    public void addVertex(Vertex v){            // putter vertex ind i arraylist
        vertices.add(v);
    }
    public void addEdge(Vertex f,Vertex t, Integer w){          // from,to,weight
        if(!(vertices.contains(f) && vertices.contains(t)) ) {
            System.out.println("Vertex not in graph");
            return;
        }
        // It is here that I make the edges/cities bidirectional by adding Edge1.
        Edge Edge=new Edge(f,t,w);
        Edge Edge1=new Edge(t,f,w);
    }
    public void MSTPrims()  {
        MinHeap<Vertex> Q = new MinHeap<>();            // create minheap (other doesnt exists)
        ArrayList<Vertex> VertexInMST = new ArrayList<>();  // liste over brugte byer            
        if(vertices.size()>0)                               // test, om der mangler nogle byer (hvis større end null)
            vertices.get(0).distance=0;                     // set distancen til null i første vertex
        else    
            return;
        for(int i=0;i<vertices.size();i++) {                // add all vertices til min heap
            Q.Insert(vertices.get(i));                      // found and got
        }

        // The algorithm
        int MST = 0;
        while(!Q.isEmpty()) {                                   // run until empty
            Vertex minVertex = Q.extractMin();                  // beder min heap om at give mindste og giver minVertex (tager også ud af minheap og rebalancere sig selv)
            VertexInMST.add(minVertex);                         // add'er til prim
            MST += minVertex.distance;                          // add'er og regner total distancen
            for (Edge outEdge: minVertex.OutEdges) {            // finder outedges og iterere dem
                if(!VertexInMST.contains(outEdge.to)  && outEdge.weight < outEdge.to.distance)  // tjekker om det allerede er taget, && tjekker om en af dem er mindre end distancen
                {
                    outEdge.to.distance = outEdge.weight;       // updatere distancen i edges
                    outEdge.to.prev = minVertex;                // sætter den sidste som minVertex
                    int pos = Q.getPosition(outEdge.to);        // spørger minheap hvor er den nye vertex vi vil opdatere
                    Q.decreasekey(pos);                         // updates min heap
                }
            }
        }
        System.out.println("Minimum spanning tree distance: " +MST);
        for(int i = 1; i< VertexInMST.size(); i++)
        {
            System.out.println(" parent "+ VertexInMST.get(i).prev.name + " to " + VertexInMST.get(i).name +" EdgeWeight: "+ VertexInMST.get(i).distance);
        }
    }
    public  void PrintGraph(){
        for (Vertex vertex : vertices) {                        // enhanced for loop, 
            System.out.println(" From: " + vertex.name);
            for (int j = 0; j < vertex.OutEdges.size(); j++) {
                Edge currentEdge = vertex.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.to.name + " km: " + currentEdge.weight);
            }
            System.out.println(" ");
        }
    }
}
class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer distance = Integer.MAX_VALUE;       // ved ikke hvad vertex value er så sætter det til max_value
    Vertex prev = null;                         // når fundet korteste rute bliver prev vertex null
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }
    @Override
    public int compareTo(Vertex o) {
        return this.distance.compareTo(o.distance);
    }
}
class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }
}
