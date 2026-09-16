import java.util.*;

public class AdjacencyList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        // Create an empty list for every vertex
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Number of edges
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        // Input edges
        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            // Undirected graph
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        // Display adjacency list
        System.out.println("\nAdjacency List:");

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}