package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graphs {

    public static void main(String[] args) {
        Graph myGraph = new Graph(8);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(0, 3);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(4, 3);
        myGraph.addEdge(5, 6);
        myGraph.addEdge(6, 7);


        DepthFirstPath sixthNode = new DepthFirstPath(myGraph, 0);

//         to find the vertices connected to a particular node.
//        for (int adj: myGraph.adj(6)) {
//            System.out.println(adj);
//        }

//        System.out.println(sixthNode.hasPathTo(4));
        System.out.println(sixthNode.pathTo(4));
    }

}

class BreadthFirstPath{
    private boolean[] marked;
    private int[] edgedTo;
    private int referenceVertex;

    public BreadthFirstPath(Graph graph, int referenceVertex){
        /*
         * The main thing happening here is that we keep things in
         * place regarding a particular reference node and then so
         * that we can be able to answer some questions from a
         * client code.
         */
        this.referenceVertex = referenceVertex;
        marked = new boolean[graph.size()];
        edgedTo = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            edgedTo[i] = -1;
        }

        bfs(graph, referenceVertex);
    }

    public void bfs(Graph graph, int referenceVertex){
        /*
         *
         * The main idea here is that for us to be able to process all
         * the vertexes on a particular level before moving to another
         * one, we have to store all them somewhere and then pick them
         * one by one.
         *
         * Thus, we first of all add the reference vertex and mark that
         * index as visited on the marked array. Then we go into the
         * linked list at that vertex and for each vertex (item) on the list that
         * is not marked, add it to the queue, mark it and keep record
         * of where it was visited from. Once the linked list for the
         * current vertex is exhausted, we pick the next vertex on the queue
         * and repeat the process above with the linked list in that vertex.
         *
         * By doing this, we will explore all the vertexes that are connected
         * to the reference vertex. Also, for any chosen vertex, we will visit
         * all its children and store them in the stack. So once we are done
         * with all then children, we pick the first child that was stored in
         * stack and visit its own children ( grand children of the original
         * vertex ). After this, we pick the second child and so on and so forth
         * until no child is found in the queue which by this time, we have all
         * the grand children in the queue starting from that of the first child.
         * Then the process continues until we meet a vertex with all connected
         * vertexes marked as visited ( no new vertex ).
         *
         * The while loop will stop once the queue
         * is empty meaning that in the past, we were processing vertexes that
         * do not have anything connected them or those connected are all marked
         * visited.
         *
         * Note that you will have to create this object for each particular
         * vertex you want to use as reference.
         *
         *
         */
        Queue<Integer> q = new LinkedList<>();
        q.add(referenceVertex);
        marked[referenceVertex] = true;

        while(!q.isEmpty()){
            int currentVertex = q.remove();
            for(int vertex: graph.adj(currentVertex)){
                if(!marked[vertex]) {
                    q.add(vertex);
                    marked[vertex] = true;
                    edgedTo[vertex] = currentVertex;
                }
            }
        }
    }
}

class DepthFirstPath{
    private boolean[] marked;
    private int[] edgeTo;
    private int targetVertex;

    public DepthFirstPath(Graph graph, int targetVertex){
        this.targetVertex = targetVertex;
        marked = new boolean[graph.size()];
        edgeTo = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            edgeTo[i] = -1;
        }

        dfs(graph, targetVertex);
        System.out.println("marked; " + Arrays.toString(marked));
        System.out.println("edgeTo; " + Arrays.toString(edgeTo));

    }

    public void dfs(Graph graph, int vertex){
        /*
         * this is used to create the dynamics that clarifies
         * the relation between nodes so that future queries from
         * actual client can be processed with ease.
         *
         * Thus, this method is called on a particular node so
         * that all other nodes that are directly or indirectly
         * connected can be known.
         *
         */

        marked[vertex] = true;
        for (int currentVertex: graph.adj(vertex)) {
            if(!marked[currentVertex]){
                dfs(graph, currentVertex);
                edgeTo[currentVertex] = vertex;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Stack<Integer> pathTo(int v){
        /*
         * The loop below says for i starting from the vertex we want to
         * trace back to the reference vertex, and i is not yet the reference
         * vertex, then move to where i was called.
         *
         * Then each in case, push the i to a stack and when the loop is
         * broken, push the reference vertex to the stack.
         *
         * Notice here that we first of all ensure that both vertexes are
         * connected and then we create a stack to store the path.
         */
        if(!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != targetVertex; i = edgeTo[i]){
            path.push(i);
        }
        path.push(targetVertex);
        return path;
    }
}

class ConnectedComponents{
    private boolean[] marked;
    private int[] id;
    private int count;
    public ConnectedComponents(Graph graph) {
        marked = new boolean[graph.size()];
        id = new int[graph.size()];
        for (int v = 0; v < graph.size(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }
    public int count() { return count; }
    public int id(int v) { return id[v]; }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if (!marked[w]) dfs(G, w);
        }
    }
}


class Graph{
    private final int V;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int size(){
        return V;
    }
}
