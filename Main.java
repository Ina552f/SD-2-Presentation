public class Main {

    public static void main(String[] args) {
                MatrixGraph thisGraph = new MatrixGraph(7);
                thisGraph.addEdge(0, 1, 1);
                thisGraph.addEdge(0, 2, 5);
                thisGraph.addEdge(0, 4, 3);
                thisGraph.addEdge(1, 4, 1);
                thisGraph.addEdge(1, 5, 7);
                thisGraph.addEdge(2, 3, 1);
                thisGraph.addEdge(3, 4, 1);
                thisGraph.addEdge(3, 6, 1);
                thisGraph.addEdge(4, 2, 1);
                thisGraph.addEdge(4, 3, 3);
                thisGraph.addEdge(4, 5, 3);
                thisGraph.addEdge(4, 6, 4);
                thisGraph.addEdge(5, 6, 1);
                //thisGraph.printGraph();
                thisGraph.MSTPrims();
    }
}
