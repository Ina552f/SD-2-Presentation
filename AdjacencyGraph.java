import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MatrixGraph {
    int[][] matrixegdegraph;
    int[][] matrixweightgraph;
    MatrixGraph(int vertices){
        matrixegdegraph=new int[vertices][vertices];
        matrixweightgraph =new int[vertices][vertices];
    }
    public void addEdge(int from, int to, int weight)
    {
        matrixegdegraph[from][to]=1;
        matrixweightgraph[from][to]=weight;
    }
    public void MSTPrims(){
        int[] Distance =new int[matrixegdegraph.length];
        int[] predecessor = new int[matrixegdegraph.length];
        boolean[] visited =  new boolean[matrixegdegraph.length];
        MinHeap<Pair> Q =new MinHeap<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>(); // offer (add) poll (extactmin)

        ArrayList<Pair> VertexPairs=new ArrayList<>();
        Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor,-1);
        Arrays.fill(visited,false);
        if (matrixegdegraph.length>0)
            Distance[0]=0;
        for(int i=0;i<matrixegdegraph.length;i++) {
            VertexPairs.add(new Pair(Distance[i], i));
            Q.Insert(VertexPairs.get(i));
        }
        int MST=0;
        while(!Q.isEmpty()){
            Pair u=Q.extractMin();
            for(int v=0;v<matrixegdegraph.length;v++){
                if(matrixegdegraph[u.index][v]==1 && matrixweightgraph[u.index][v]<Distance[v])
                {
                    if(!visited[v]) {
                        Distance[v] = matrixweightgraph[u.index][v];
                        predecessor[v] = u.index;
                        int pos = Q.getPosition(VertexPairs.get(v));
                        VertexPairs.get(v).distance = matrixweightgraph[u.index][v];
                        Q.decreasekey(pos);
                    }
                }
            }
            MST+=Distance[u.index];
        }
        System.out.println("Minimum spanning tree Dsitance: " +MST);
        for(int i=0; i< matrixegdegraph.length;i++)
        {
            System.out.println(" parent "+ predecessor[i] + " to " + i + " EdgeWeight: " + Distance[i]);
        }
    }


    public void printGraph(){
        for(int fromi =0; fromi< matrixegdegraph.length; fromi++){
            System.out.println("Edges from vertex "+ fromi);
            for(int toj=0;toj<matrixegdegraph.length;toj++){
                if(matrixegdegraph[fromi][toj]==1)
                {
                    System.out.print( " To "+ toj);
                    System.out.println(" weight "+ matrixweightgraph[fromi][toj]);
                }
            }
            System.out.println(" ");
        }
    }
}

class Pair implements Comparable<Pair>{
   Integer distance;
   Integer index;

   public Pair(Integer distance, Integer index){
       this.distance=distance;
       this.index = index;
   }

   @Override
   public int compareTo(Pair p){
       return this.distance.compareTo(p.distance);
   }
}
