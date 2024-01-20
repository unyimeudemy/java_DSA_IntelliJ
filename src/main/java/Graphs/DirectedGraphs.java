package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphs {
    public static void main(String[] args) {
        DiGraph myGraph = new DiGraph(8);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(0, 3);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(4, 3);
        myGraph.addEdge(5, 6);
        myGraph.addEdge(6, 7);


        for (int i = 0; i < myGraph.size(); i++) {
            for (int currentVertex: myGraph.adj(i)) {
                System.out.println(i + " -> " + currentVertex);
            }
        }
    }

}

class DiGraph{
    private final int V;
    private LinkedList<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int size(){
        return V;
    }

    public int edges(){
        return -1;
    }
}

class DepthFirstPathDigraph{
    private boolean[] marked;
    private int[] edgeTo;

    DepthFirstPathDigraph(DiGraph graph, int referenceVertex){
        marked = new boolean[graph.size()];
        edgeTo = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            edgeTo[i] = -1;
        }
        dfs(graph, referenceVertex);
    }

    private void dfs(DiGraph graph, int targetVertex){
        marked[targetVertex] = true;
        for(int currentVertex: graph.adj(targetVertex)){
            if(!marked[currentVertex]){
                dfs(graph, currentVertex);
                edgeTo[currentVertex] = targetVertex;
            }
        }
    }


}

class BreadthFirstPathDigraph{
    private boolean[] marked;
    private int[] edgedTo;
    private int referenceVertex;

    public BreadthFirstPathDigraph(Graph graph, int referenceVertex){
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
