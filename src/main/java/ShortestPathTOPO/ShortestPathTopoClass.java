package ShortestPathTOPO;

import java.util.*;

public class ShortestPathTopoClass {
    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);


        // Adding directed weighted edges
        G.addEdge(new DirectedWeightedEdge(0, 1, 5.0));
        G.addEdge(new DirectedWeightedEdge(0, 4, 9.0));
        G.addEdge(new DirectedWeightedEdge(0, 7, 8.0));
        G.addEdge(new DirectedWeightedEdge(1, 2, 12.0));
        G.addEdge(new DirectedWeightedEdge(1, 3, 15.0));
        G.addEdge(new DirectedWeightedEdge(1, 7, 4.0));
        G.addEdge(new DirectedWeightedEdge(2, 3, 3.0));
        G.addEdge(new DirectedWeightedEdge(2, 6, 11.0));
        G.addEdge(new DirectedWeightedEdge(3, 6, 9.0));
        G.addEdge(new DirectedWeightedEdge(4, 5, 4.0));
        G.addEdge(new DirectedWeightedEdge(4, 6, 20.0));
        G.addEdge(new DirectedWeightedEdge(4, 7, 5.0));
        G.addEdge(new DirectedWeightedEdge(5, 2, 1.0));
        G.addEdge(new DirectedWeightedEdge(5, 6, 13.0));
        G.addEdge(new DirectedWeightedEdge(7, 5, 6.0));
        G.addEdge(new DirectedWeightedEdge(7, 2, 7.0));

        int source = 0;
        ShortestPathTopo topoShortestPath = new ShortestPathTopo(G, source);

        System.out.println("Shortest paths from vertex " + source + ":");
        for (int v = 0; v < G.V(); v++) {
            System.out.println("To " + v + ": " + topoShortestPath.distTo(v));
            System.out.println("Path: " + topoShortestPath.pathTo(v));
        }
    }
}

class ShortestPathTopo{
    private double[] distTo;
    private DirectedWeightedEdge[] edgeTo;

    public ShortestPathTopo(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedWeightedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        TopoSort topoSort = new TopoSort(G);
        for (int v: topoSort.sortedList()){
            for(DirectedWeightedEdge e: G.adj(v)){
                relax(e);
            }
        }
    }


    public double distTo(int v) { return distTo[v]; }
    public Iterable<DirectedWeightedEdge> pathTo(int v) {
        Stack<DirectedWeightedEdge> path = new Stack<DirectedWeightedEdge>();

        for (DirectedWeightedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    public void relax(DirectedWeightedEdge e){
        int v = e.from();
        int w = e.to();

        if(distTo[w] > distTo[v] + e.getWeight()){
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
        }
    }
}

class DirectedWeightedEdge{
    private final int v, w;
    private final double weight;

    public DirectedWeightedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String toString (){
        return w + " -> " + v;
    }
}

class EdgeWeightedDigraph{
    private final int V;
    private int E;
    private final LinkedList<DirectedWeightedEdge>[] adj;

    public EdgeWeightedDigraph(int V){
        this.V = V;
        adj = (LinkedList<DirectedWeightedEdge>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<DirectedWeightedEdge>();
        }
    }

    public void addEdge(DirectedWeightedEdge e){
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedWeightedEdge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public Iterable<DirectedWeightedEdge> edges(){
        LinkedList<DirectedWeightedEdge> allEdges = new LinkedList<DirectedWeightedEdge>();
        for (int i = 0; i < V; i++) {
            allEdges.addAll(adj[i]);
        }
        E = allEdges.size();
        return allEdges;
    }

    public int E(){
        return E;
    }
}

class TopoSort {
    private boolean[] marked;
    private Stack<Integer> reversePost;
    private boolean hasCycle; // New boolean flag to indicate the presence of a cycle

    public TopoSort(EdgeWeightedDigraph graph) {
        marked = new boolean[graph.V()];
        reversePost = new Stack<>();
        hasCycle = false; // Initialize the cycle flag
        for (int vertex = 0; vertex < graph.V(); vertex++) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph graph, int targetVertex) {
        marked[targetVertex] = true;
        for (DirectedWeightedEdge currentVertex : graph.adj(targetVertex)) {
            if (!marked[currentVertex.to()]) {
                dfs(graph, currentVertex.to());
            } else if (!reversePost.contains(currentVertex)) {
                // If the current vertex is already marked and not part of the reversePost stack,
                // then there is a cycle in the graph
                hasCycle = true;
            }
        }
        reversePost.push(targetVertex);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public void display() {
        while (!reversePost.isEmpty()) {
            System.out.print(reversePost.pop() + " ");
        }
    }

    public Iterable<Integer> sortedList(){
        ArrayList<Integer> list = new ArrayList<>();
        while (!reversePost.isEmpty()) {
            list.add(reversePost.pop());
        }
        return list;
    }
}



