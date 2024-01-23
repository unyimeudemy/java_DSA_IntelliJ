package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class MST {
    public static void main(String[] args)
    {

        EdgeWeightedGraph G = new EdgeWeightedGraph(6);
        MinimumSpanningTree mst = new MinimumSpanningTree(G);
        for (Edge e : mst.edges()){
            System.out.println(e);
        }
        System.out.println(mst.weight());
    }
}

class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v){
            return w;
        }else {
            return v;
        }
    }

    public int compareTo(Edge e){
        if(this.weight == e.weight){
            return 0;
        }else if (this.weight > e.weight){
            return 1;
        }else{
            return -1;
        }
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return v + " - " + w + "(" + weight + ")";
    }
}

class EdgeWeightedGraph{
    private final int V;
    /*
     * Note here that since we are mainly concerned with the edges, we
     * will be storing the edges in the linked list instead of adjacent
     * vertexes. This is because the edges have both the connected
     * vertexes and the edge.
     *
     * With this, and edge will actually appear twice in two linked list.
     * One for each vertex that is part of the edge. Please note that it is
     * not the object that appears twice but a reference to the edge object.
     */
    private final LinkedList<Edge>[] adj;
    LinkedList<Edge> allEdges = new LinkedList<Edge>();


    public EdgeWeightedGraph(int V){
        this.V = V;
        this.adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Edge>();

        }
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        for (int i = 0; i < V; i++) {
            allEdges.addAll(adj[i]);
        }
        return allEdges;
    }

    public int V(){
        return V;
    }

    public int E(){
        return allEdges.size();
    }

}

class MinimumSpanningTree{
    public MinimumSpanningTree(EdgeWeightedGraph G){

    }

    public Iterable<Edge> edges(){
        return new LinkedList<Edge>();
    }

    public double weight (){
        return 4.0;
    }
}

class KruskalMST{

}