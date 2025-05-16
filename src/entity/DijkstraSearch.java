package entity;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph ,Vertex<V> source) {
        super(source);

        dijkstra(graph,source);
    }

    private void dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        Map<Vertex<V>,Double> distance = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>((v1,v2)-> Double.compare(distance.get(v1),distance.get(v2)));

        for(Vertex<V> v : graph.getGraph()){
            distance.put(v,Double.POSITIVE_INFINITY);
        }
        distance.put(source,0.0);
        queue.add(source);
        super.visited.add(source);
        super.fromMap.put(source,null);

        while(!queue.isEmpty()){
            Vertex<V> current = queue.poll();

            for(Map.Entry<Vertex<V>,Double> neighbor : current.getAdjacencyVertices().entrySet() ){
                Vertex<V> neighborVertex = neighbor.getKey();
                double weight = neighbor.getValue();

                double newWeight = weight + distance.get(current);
                if(newWeight < distance.get(neighborVertex)){
                    distance.put(neighborVertex,newWeight);
                    super.fromMap.put(neighborVertex,current);
                    queue.remove(neighborVertex);
                    queue.add(neighborVertex);

                    super.visited.add(neighborVertex);
                }
            }
        }
    }
}
