import java.util.*;

public class Dijkstra {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static int[] dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[source] = 0;
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int u = current.vertex;
            int currentDistance = current.distance;

            // Ignore outdated entries
            if (currentDistance > dist[u]) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int newDistance = dist[u] + edge.weight;

                // Relaxation
                if (newDistance < dist[v]) {
                    dist[v] = newDistance;
                    pq.offer(new Node(v, newDistance));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed edges: from -> to, weight
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int source = 0;

        int[] distances = dijkstra(graph, source);

        for (int i = 0; i < distances.length; i++) {
            System.out.println(
                source + " -> " + i + " = " + distances[i]
            );
        }
    }
}