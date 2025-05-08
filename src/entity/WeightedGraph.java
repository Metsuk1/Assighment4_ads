package entity;

import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex,List<Edge<Vertex>>> adjList;
    private boolean undirected;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if(!hasVertex(v)) {
            return;
        }

        adjList.put(v,new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if(!hasVertex(source)){
            addVertex(source);
        }
        if(!hasVertex(dest)){
            addVertex(dest);
        }


        if(undirected) {
            adjList.get(dest).add(new Edge<Vertex>(dest,source,weight));
        }
    }

    public boolean hasVertex(Vertex v) {
        return adjList.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Edge dest) {
        if(!hasVertex(source)) {return false;}
        return adjList.get(source).contains(dest);
    }


}
