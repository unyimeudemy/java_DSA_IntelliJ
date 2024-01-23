package LazyPrimsMST;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {
    public static void main(String[] args) {

        EdgeWeightedGraph G = new EdgeWeightedGraph(8);

        G.addEdge(new Edge(0, 7, 0.16));
        G.addEdge(new Edge(2, 3, 0.17));
        G.addEdge(new Edge(1, 7, 0.19));
        G.addEdge(new Edge(0, 2, 0.26));
        G.addEdge(new Edge(5, 7, 0.28));
        G.addEdge(new Edge(1, 3, 0.29));
        G.addEdge(new Edge(1, 5, 0.32));
        G.addEdge(new Edge(2, 7, 0.34));
        G.addEdge(new Edge(4, 5, 0.35));
        G.addEdge(new Edge(1, 2, 0.36));
        G.addEdge(new Edge(4, 7, 0.37));
        G.addEdge(new Edge(0, 4, 0.38));
        G.addEdge(new Edge(6, 2, 0.40));
        G.addEdge(new Edge(3, 6, 0.52));
        G.addEdge(new Edge(6, 0, 0.58));
        G.addEdge(new Edge(6, 4, 0.93));

        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()){
            System.out.println(e);
        }
    }
}

class Edge implements Comparable<Edge>{
    /*
     * Since the whole algorithm is centered around
     * the weight of the edge, we will create a separate edge
     * object using the vertexes that make it up and weight of the
     * edge.
     */
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        /*
         * This method return the current vertex. This is
         * possible because at any point in time, we are always holding
         * onto a vertex
         */
        return v;
    }

    public int other(int vertex){
        /*
         * This method takes in a given vertex that make up an
         * edge and then returns the other vertex that make up the
         * edge.
         */
        if(vertex == v){
            return w;
        }else {
            return v;
        }
    }

    public int compareTo(Edge e){
        /*
         * This is used to compare two vertexes inorder to determine
         * how the vertexes will be arranged on the priority queue.
         * Note here that this format is used since we want to have
         * a minimum priority queue. Doing something like
         *      return e.weight - this.weight
         * will give a maximum priority queue.
         */
        if(this.weight == e.weight){
            return 0;
        }else if (this.weight > e.weight){
            return 1;
        }else{
            return -1;
        }

    }

    public double getWeight(){
        // this returns the weight of the edge we are currently
        // considering.
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
        /*
         * we get an edge and insert it into the appropriate
         * adjacent vertex linked list.
         */
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v){
        // Returns the linked list at a particular index
        return adj[v];
    }

    public Iterable<Edge> edges(){
        /*
         * Here we iterate through the array that stores the linked
         * list and for each linked list, we take all the edges that
         * is the linked list and add them to them a general list
         * that is intended to contain all the edges that make up the
         * graph.
         */
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


class LazyPrimMST{
    /*
     * Here we declare the marked array to keep track of
     * which vertexes have been visited, a mst queue to store
     * all the edges that belong to the MST and priority queue
     * that stores all the edges going from the connected
     * component to the rest of the graph.
     */
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G){
        /*
         * Here we initialize all the variables declared above
         * and visit the first vertex.
         *
         * Basically, the visit() method marks the visited vertex as
         * visited then goes through all the edges adjacent to
         * the chosen vertex. For each adjacent edge, check if the
         * vertex at the other edge as been visited. And if it has
         * not, it means that the edge has not been processed thus
         * push it to the priority queue.
         */
        marked = new boolean[G.V()];
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        visit(G, 0);

        while(!pq.isEmpty() && mst.size() < G.V() - 1){
            /*
             * Once the first set of edges (from the first vertex)
             * to be considered has been pushed to the priority
             * queue, we start picking the least weighted edge and
             * process.
             *
             * for each edge from pq, get both vertexes that make up the
             * edge and if both are marked true, that is they have been
             * visited, start the while loop again and pick the next edge
             * on pq.
             *
             * But for any of the vertexes that is marked true, call the
             * visit() method on it. On calling the visit() method on
             * these vertexes, you have stored all the edges connected to them
             * in the pq.
             */
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]){continue;}
            mst.add(e);
            if(!marked[v]){visit(G, v);}
            if(!marked[w]){visit(G, w);}
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e: G.adj(v)){
            if(!marked[e.other(v)]){
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges(){
        return new LinkedList<>(mst);
    }

}


