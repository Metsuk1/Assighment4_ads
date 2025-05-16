package entity;

import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacencyVertices;

    public Vertex(V data) {
        this.data = data;
        adjacencyVertices = new HashMap<>();
    }

    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjacencyVertices.put(dest, weight);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacencyVertices() {
        return adjacencyVertices;
    }

    public void setAdjacencyVertices(Map<Vertex<V>, Double> adjacencyVertices) {
        this.adjacencyVertices = adjacencyVertices;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
