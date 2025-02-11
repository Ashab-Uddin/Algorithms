import java.util.*;

public class CycleDetectionBFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
        visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (format: u v where u and v are node indices):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // Since it's an undirected graph
        }

        boolean cycleFound = false;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) { // Check all components of the graph
                if (bfsCycleCheck(i)) {
                    cycleFound = true;
                    break;
                }
            }
        }

        if (cycleFound) {
            System.out.println("Cycle detected in the graph!");
        } else {
            System.out.println("No cycle found.");
        }

        scanner.close();
    }

    static boolean bfsCycleCheck(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // Start BFS with (-1) as parent
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int node = nodeInfo[0];
            int parent = nodeInfo[1];

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(new int[]{neighbor, node});
                    visited[neighbor] = true;
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
}
