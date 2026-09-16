import java.util.Scanner;

public class DFS {

    static void dfs(int[][] graph, boolean[] visited, int current, int vertices) {

        // Mark current vertex as visited
        visited[current] = true;

        System.out.print(current + " ");

        // Visit all adjacent vertices
        for (int i = 0; i < vertices; i++) {

            if (graph[current][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, vertices);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        // Adjacency matrix
        int[][] graph = new int[vertices][vertices];

        // Number of edges
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        // Input edges
        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            // Undirected graph
            graph[source][destination] = 1;
            graph[destination][source] = 1;
        }

        // Starting vertex
        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");

        dfs(graph, visited, start, vertices);

        sc.close();
    }
}