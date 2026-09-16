import java.util.*;

public class BFS {

    static void bfs(int[][] graph, int start, int vertices) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        // Start vertex
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            // Remove from front
            int current = queue.poll();

            System.out.print(current + " ");

            // Check all adjacent vertices
            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] == 1 && !visited[i]) {

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            // Undirected graph
            graph[source][destination] = 1;
            graph[destination][source] = 1;
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        bfs(graph, start, vertices);

        sc.close();
    }
}