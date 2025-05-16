package entity;

import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> graph;
    private boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public WeightedGraph() {
        this(true);
    }

    public void addVertex(Vertex<V> v) {
        graph.add(v);
        graph = new HashSet<>();
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!hasVertex(source)) {
            graph.add(source);
        }

        if (!hasVertex(destination)) {
            graph.add(destination);
        }

        source.addAdjVertex(destination, weight);

        if (undirected) {
            destination.addAdjVertex(source, weight);
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


    public Set<Vertex<V>> getGraph() {
        return graph;
    }

    public void setGraph(Set<Vertex<V>> graph) {
        this.graph = graph;
    }

    public boolean isUndirected() {
        return undirected;
    }

    public void setUndirected(boolean undirected) {
        this.undirected = undirected;
    }

}
