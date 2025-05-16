package entity;

import java.util.*;

public class BreadthFirstSearch<V> extends Search<V>{
    public BreadthFirstSearch(WeightedGraph<Vertex<V>> graph,Vertex<V> source) {
        super(source);

        bfs(graph,source);
    }


    private void bfs(WeightedGraph<Vertex<V>> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        super.visited.add(start); // we marked the start point as the visited
        super.fromMap.put(start,null);
        queue.add(start); // adding to the queue

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll(); // extract current vertex

            /**
             * We go around all the neighbors of the current vertex.
             */
            for (Vertex<V> neighbor : current.getAdjacencyVertices().keySet()) {
                if (!super.visited.contains(neighbor)) {
                    super.visited.add(neighbor);// mark as visited
                    fromMap.put(neighbor, current); // so that the path can be restored later
                    queue.add(neighbor); // кидаем в очередбь
                }
            }
        }
    }
}
