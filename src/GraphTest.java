import entity.*;

public class GraphTest {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Vertex<String> almatyVertex = getVertex(weightedGraph, "Almaty");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, almatyVertex);
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(weightedGraph, almatyVertex);
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        // Create vertices and add edges with weights
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(astana, shymkent, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<Vertex<String>> path = search.pathTo(new Vertex<>(key));
        if (path == null) {
            System.out.println("No path found to " + key);
            return;
        }

        for (Vertex<String> v : path) {
            System.out.print(v.getData() + " -> ");
        }
        System.out.println();
    }

    // Helper method to find a vertex in the graph by its data
    private static Vertex<String> getVertex(WeightedGraph<String> graph, String data) {
        for (Vertex<String> vertex : graph.getGraph()) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
}