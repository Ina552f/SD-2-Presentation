import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyGraph {
    ArrayList<Vertex> vertices;

    public AdjacencyGraph(){
        vertices=new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v){
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
        MinHeap<Vertex> Q = new MinHeap<>();
        ArrayList<Vertex> VertexInMST = new ArrayList<>();              
        if(vertices.size()>0)
            vertices.get(0).distance=0;        
        for(int i=0;i<vertices.size();i++) {
            Q.Insert(vertices.get(i));
        }

        // The algorithm
        int MST = 0;
        while(!Q.isEmpty()) {
            Vertex minVertex = Q.extractMin();
            VertexInMST.add(minVertex);
            MST += minVertex.distance;
            for (Edge outEdge: minVertex.OutEdges) {            // what are there of outedges
                if(!VertexInMST.contains(outEdge.to)  && outEdge.weight < outEdge.to.distance)  // tjekker om det allerede er taget, && tjekker om en af dem er mindre end distancen
                {
                    outEdge.to.distance = outEdge.weight;
                    outEdge.to.prev = minVertex;                // sætter den sidste som minVertex
                    int pos = Q.getPosition(outEdge.to);
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
        for (Vertex vertex : vertices) {
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
    Integer distance = Integer.MAX_VALUE;       // ved ikke hvad vertex value er så sætter det bare til max_value
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
