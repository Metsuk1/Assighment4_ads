package entity;

public class DijkstraSearch extends Search<Vertex> {



    public DijkstraSearch(WeightedGraph<Vertex> graph ,Vertex source) {
        super(source);
    }
}
