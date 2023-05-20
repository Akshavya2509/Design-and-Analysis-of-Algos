public class Solution {
    int[] color;

    boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, i, 1)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int[][] graph, int node, int c) {
        color[node] = c;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == c) {
                return false;  // Not bipartite
            }

            if (color[neighbor] == 0 && !dfs(graph, neighbor, -c)) {
                return false;  // Not bipartite
            }
        }

        return true;
    }
}
