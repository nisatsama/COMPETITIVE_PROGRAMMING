import java.util.Scanner;

public class Prims {

    static final int INF = 999999;

    static void prims(int[][] graph, int vertices) {

        // Stores whether vertex is included in MST
        boolean[] visited = new boolean[vertices];

        // Minimum edge weight to connect each vertex
        int[] minWeight = new int[vertices];

        // Parent of each vertex in MST
        int[] parent = new int[vertices];

        // Initially, all vertices have infinite weight
        for (int i = 0; i < vertices; i++) {
            minWeight[i] = INF;
            parent[i] = -1;
        }

        // Start from vertex 0
        minWeight[0] = 0;

        int totalCost = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        // MST has V - 1 edges
        for (int count = 0; count < vertices; count++) {

            // Find vertex with minimum edge weight
            int u = -1;
            int min = INF;

            for (int i = 0; i < vertices; i++) {

                if (!visited[i] && minWeight[i] < min) {
                    min = minWeight[i];
                    u = i;
                }
            }

            // Mark vertex as included
            visited[u] = true;

            // Print edge except for starting vertex
            if (parent[u] != -1) {

                System.out.println(
                        parent[u] + " - " + u +
                        " : " + graph[parent[u]][u]
                );

                totalCost += graph[parent[u]][u];
            }

            // Update neighboring vertices
            for (int v = 0; v < vertices; v++) {

                if (graph[u][v] != 0 &&
                    !visited[v] &&
                    graph[u][v] < minWeight[v]) {

                    minWeight[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Minimum Cost = " + totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges as: source destination weight");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            // Undirected weighted graph
            graph[source][destination] = weight;
            graph[destination][source] = weight;
        }

        prims(graph, vertices);

        sc.close();
    }
}