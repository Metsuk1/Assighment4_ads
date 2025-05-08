package entity;

import java.util.Objects;

public class Edge<Vertex>{
    private Vertex source; //from
    private Vertex destination; //to
    private double weight;

    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        weight = 0;
    }

    public Edge(Vertex source, Vertex destination, double weight) {
        this( source, destination);
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Edge<?> edge = (Edge<?>) object;
        return Double.compare(getWeight(), edge.getWeight()) == 0 && Objects.equals(getSource(), edge.getSource()) && Objects.equals(getDestination(), edge.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getDestination(), getWeight());
    }
}
