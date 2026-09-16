import java.util.Scanner;

public class AdjacencyMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        // Create adjacency matrix
        int[][] matrix = new int[vertices][vertices];

        // Number of edges
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        // Input edges
        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            // Undirected graph
            matrix[source][destination] = 1;
            matrix[destination][source] = 1;
        }

        // Display matrix
        System.out.println("\nAdjacency Matrix:");

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}