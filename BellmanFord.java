import java.util.*;

public class BellmanFord {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void bellmanFord(int V, List<Edge> edges, int source) {

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i <= V - 1; i++) {

            boolean updated = false;

            for (Edge edge : edges) {

                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                    updated = true;
                }
            }

            // Optimization: stop if no update occurred
            if (!updated) {
                break;
            }
        }

        // Check for negative-weight cycle
        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + weight < dist[v]) {

                System.out.println("Negative weight cycle exists.");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : INF");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, -3));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(1, 4, 10));

        int source = 0;

        bellmanFord(V, edges, source);
    }
}