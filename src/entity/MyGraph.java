package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {
    private Map<Vertex<T>,List<Edge<T>>> adjList;
    private boolean directed;

}
