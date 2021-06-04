public class Main {
    public static void main(String[] args) {
        AdjacencyGraph MyGraph=new AdjacencyGraph();
        Vertex a = new Vertex("Eskildstrup");
        Vertex b = new Vertex("Haslev");
        Vertex c = new Vertex("Holbæk");
        Vertex d = new Vertex("Jærgerspris");
        Vertex e = new Vertex("Kalundborg");
        Vertex f = new Vertex("Korsør");
        Vertex g = new Vertex("Køge");
        Vertex h = new Vertex("Maribo");
        Vertex i = new Vertex("Nakskov");
        Vertex j = new Vertex("Nykøbing F");
        Vertex k = new Vertex("Næstved");
        Vertex l = new Vertex("Ringsted");
        Vertex m = new Vertex("Roskilde");
        Vertex n = new Vertex("Slagelse");
        Vertex o = new Vertex("Sorø");
        Vertex p = new Vertex("Vordingborg");
        // Here Vertex is added to the graph
        MyGraph.addVertex(a);
        MyGraph.addVertex(b);
        MyGraph.addVertex(c);
        MyGraph.addVertex(d);
        MyGraph.addVertex(e);
        MyGraph.addVertex(f);
        MyGraph.addVertex(g);
        MyGraph.addVertex(h);
        MyGraph.addVertex(i);
        MyGraph.addVertex(j);
        MyGraph.addVertex(k);
        MyGraph.addVertex(l);
        MyGraph.addVertex(m);
        MyGraph.addVertex(n);
        MyGraph.addVertex(o);
        MyGraph.addVertex(p);
        // Here I add the edges and their weight (in this case printed as 'km'). At this point it is not bidirectional
        // as the code would become double what it is now.
        MyGraph.addEdge(a,h,28);
        MyGraph.addEdge(a,j,13);
        MyGraph.addEdge(a,p,24);
        MyGraph.addEdge(b,f,60);
        MyGraph.addEdge(b,g,24);
        MyGraph.addEdge(b,k,25);
        MyGraph.addEdge(b,l,19);
        MyGraph.addEdge(b,m,47);
        MyGraph.addEdge(b,n,48);
        MyGraph.addEdge(b,o,34);
        MyGraph.addEdge(b,p,40);
        MyGraph.addEdge(c,d,34);
        MyGraph.addEdge(c,e,44);
        MyGraph.addEdge(c,f,66);
        MyGraph.addEdge(c,l,36);
        MyGraph.addEdge(c,m,32);
        MyGraph.addEdge(c,n,46);
        MyGraph.addEdge(c,o,34);
        MyGraph.addEdge(d,f,95);
        MyGraph.addEdge(d,g,58);
        MyGraph.addEdge(d,l,56);
        MyGraph.addEdge(d,m,33);
        MyGraph.addEdge(d,n,74);
        MyGraph.addEdge(d,o,63);
        MyGraph.addEdge(e,l,62);
        MyGraph.addEdge(e,m,70);
        MyGraph.addEdge(e,n,39);
        MyGraph.addEdge(e,o,51);
        MyGraph.addEdge(f,k,45);
        MyGraph.addEdge(f,n,20);
        MyGraph.addEdge(g,k,45);
        MyGraph.addEdge(g,l,28);
        MyGraph.addEdge(g,m,25);
        MyGraph.addEdge(g,p,60);
        MyGraph.addEdge(h,i,27);
        MyGraph.addEdge(h,j,26);
        MyGraph.addEdge(k,m,57);
        MyGraph.addEdge(k,l,26);
        MyGraph.addEdge(k,n,37);
        MyGraph.addEdge(k,o,32);
        MyGraph.addEdge(k,p,28);
        MyGraph.addEdge(l,m,31);
        MyGraph.addEdge(l,o,15);
        MyGraph.addEdge(l,p,58);
        MyGraph.addEdge(n,o,14);
        MyGraph.PrintGraph();

        MyGraph.MSTPrims();
    }
}
