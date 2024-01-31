package ShortestPath;

import java.util.*;

public class ShortestPath {
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
        Dijkstra dijkstra = new Dijkstra(G, source);

        System.out.println("Shortest paths from vertex " + source + ":");
        for (int v = 0; v < G.V(); v++) {
            System.out.println("To " + v + ": " + dijkstra.distTo(v));
            System.out.println("Path: " + dijkstra.pathTo(v));
        }
    }
}

class Dijkstra{
    private double[] distTo;
    private DirectedWeightedEdge[] edgeTo;

    private IndexedMinPriorityQueue pq;
    public Dijkstra(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedWeightedEdge[G.V()];
        pq = new IndexedMinPriorityQueue(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedWeightedEdge e : G.adj(v))
                relax(e);
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
            if (pq.contains(w)){
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert (w, distTo[w]);
            }
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


class IndexedMinPriorityQueue {
    private ArrayList<IndexedVertexInfo> heap;
    private Map<Integer, Integer> indexMap;

    public IndexedMinPriorityQueue(int capacity) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>(capacity);
    }

    public void insert(int index, double key) {
        heap.add(new IndexedVertexInfo(index, key));
        indexMap.put(index, heap.size() - 1);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    public boolean contains(int index) {
        return indexMap.containsKey(index);
    }

    public int delMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int minIndex = heap.get(0).getVertex();
        swap(0, heap.size() - 1);
        indexMap.remove(minIndex);

        int removedIndex = heap.remove(heap.size() - 1).getVertex();
        heapify(0);

        return removedIndex;
    }

    public void decreaseKey(int index, double newKey) {
        if (!indexMap.containsKey(index)) {
            throw new IllegalArgumentException("Index not found in the heap");
        }

        int currentIndex = indexMap.get(index);
        if (newKey >= heap.get(currentIndex).getDistTo()) {
            throw new IllegalArgumentException("New key is not smaller than the current key");
        }

        heap.get(currentIndex).setDistTo(newKey);
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    private void heapify(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        int smallestIndex = currentIndex;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != currentIndex) {
            swap(currentIndex, smallestIndex);
            heapify(smallestIndex);
        }
    }

    private void swap(int first, int second) {
        IndexedVertexInfo valueAtFirst = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, valueAtFirst);

        indexMap.put(heap.get(first).getVertex(), first);
        indexMap.put(heap.get(second).getVertex(), second);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private static class IndexedVertexInfo implements Comparable<IndexedVertexInfo> {
        private final int vertex;
        private double distTo;

        public IndexedVertexInfo(int vertex, double distTo) {
            this.vertex = vertex;
            this.distTo = distTo;
        }

        public int getVertex() {
            return vertex;
        }

        public double getDistTo() {
            return distTo;
        }

        public void setDistTo(double distTo) {
            this.distTo = distTo;
        }

        @Override
        public int compareTo(IndexedVertexInfo other) {
            return Double.compare(this.distTo, other.distTo);
        }
    }
}


