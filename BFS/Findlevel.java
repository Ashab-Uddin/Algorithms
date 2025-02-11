import java.util.*;

public class Findlevel {
    static List<List<Integer>> graph = new ArrayList<>();
    static char[] c;
    static boolean[] visited;
    static int[] level; // Stores level of each node
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
        c = new char[nodes];
        visited = new boolean[nodes];
        level = new int[nodes]; // Initialize level array

        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
            System.out.print("Enter label for node " + i + ": ");
            c[i] = scanner.next().charAt(0);
        }

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (format: u v where u and v are node indices):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // Assuming an undirected graph
        }

        System.out.print("Enter starting node index for BFS: ");
        int start = scanner.nextInt();

        bfs(start);
        scanner.close();
    }

    static void bfs(int start) {
        queue.add(start);
        visited[start] = true;
        level[start] = 0; // Start node level is 0

        System.out.println("\nBFS Traversal with Levels:");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Node: " + c[node] + ", Level: " + level[node]);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    level[neighbor] = level[node] + 1; // Set level of the neighbor
                }
            }
        }
    }
}
