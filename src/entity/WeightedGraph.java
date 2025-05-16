package entity;

import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> graph;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        setDirected(directed);
        this.graph = new HashSet<>();

    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(Vertex<V> v) {
        graph.add(v);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }

        if (!hasVertex(destination)) {
            addVertex(destination);
        }

        source.addAdjVertex(destination, weight);

        if (!directed) {
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

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

}
