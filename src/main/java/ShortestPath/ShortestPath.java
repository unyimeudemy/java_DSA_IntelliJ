package ShortestPath;

import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {

}

class SP{
    private int[] distTo;
    private DirectedWeightedEdge[] edgeTo;
    public SP(EdgeWeightedDigraph G, int s){

    }

    public double distTo(int v) { return distTo[v]; }
    public Iterable<DirectedWeightedEdge> pathTo(int v) {
        Stack<DirectedWeightedEdge> path = new Stack<DirectedWeightedEdge>();
        for (DirectedWeightedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
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