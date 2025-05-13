package entity;

import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> graph = new HashSet<>();
    private boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public WeightedGraph() {
        this(true);
    }

    public void addVertex(Vertex<V> v) {
        graph.add(v);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!hasVertex(source)) {
            graph.add(source);
        }

        if (!hasVertex(destination)) {
            graph.add(destination);
        }

        source.addEdge(destination, weight);

        if (undirected) {
            destination.addEdge(source, weight);
        }
    }

    public boolean hasVertex(Vertex<V> vertex) {
        return graph.contains(vertex);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }

        return source.getAdjacencyVertices().containsKey(destination);
    }


}
