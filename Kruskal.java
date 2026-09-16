import java.util.*;

public class Kruskal {

    // Edge class
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Find parent of a vertex
    static int find(int[] parent, int vertex) {

        if (parent[vertex] == vertex) {
            return vertex;
        }

        return parent[vertex] =
                find(parent, parent[vertex]);
    }

    // Union two sets
    static void union(int[] parent, int[] rank,
                      int a, int b) {

        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            }
            else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            }
            else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    static void kruskal(ArrayList<Edge> edges,
                        int vertices) {

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // Initially, every vertex is its own parent
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int edgeCount = 0;
        int totalCost = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        for (Edge edge : edges) {

            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            // If roots are different, adding edge won't create cycle
            if (rootSource != rootDestination) {

                System.out.println(
                        edge.source + " - " +
                        edge.destination + " : " +
                        edge.weight
                );

                totalCost += edge.weight;

                union(parent, rank,
                      edge.source,
                      edge.destination);

                edgeCount++;

                // MST contains V - 1 edges
                if (edgeCount == vertices - 1) {
                    break;
                }
            }
        }

        System.out.println("Minimum Cost = " + totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int numberOfEdges = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println(
                "Enter edges as: source destination weight"
        );

        for (int i = 0; i < numberOfEdges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            edges.add(
                    new Edge(source, destination, weight)
            );
        }

        kruskal(edges, vertices);

        sc.close();
    }
}