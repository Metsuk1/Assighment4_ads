package entity;

import java.util.*;

public class Search<V> {
    private final Vertex<V> source;
    protected Set<Vertex> visited;
    protected Map<Vertex<V>, Vertex<V>> fromMap;

    public Search(Vertex<V> source) {
        this.source = source;
        visited = new HashSet<>();
        fromMap = new HashMap<>();
    }


    public boolean hasPathTo(Vertex<V> v) {
        return visited.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) {
            return null;
        }

        LinkedList<Vertex<V>> list = new LinkedList<>();
        for (Vertex<V> i = v; i != source; i = fromMap.get(i)) {
            list.push(i);
        }
        list.push(source);

        return list;
    }
}
