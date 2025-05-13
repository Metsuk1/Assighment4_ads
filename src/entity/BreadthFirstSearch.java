package entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<V> extends Search<Vertex<V>>{
    public BreadthFirstSearch(WeightedGraph<Vertex<V>> graph,Vertex<V> source) {
        super((Vertex<Vertex<V>>) source);

  //      bfs();
    }



    private void bfs(Vertex<V> current, Set<Vertex<V>> visited){
        Queue<Vertex<V>> queue = new LinkedList<Vertex<V>>();

    }
}
