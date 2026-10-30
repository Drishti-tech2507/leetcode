import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build graph adjacencies
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        // dist[u][count] = min distance to reach node u with `count` consecutive matching labels ending at u
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Priority Queue elements: {cost, u, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int count = curr[2];

            if (cost > dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return cost;
            }

            char currLabel = labels.charAt(u);

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                char nextLabel = labels.charAt(v);

                int nextCount = (currLabel == nextLabel) ? count + 1 : 1;

                if (nextCount <= k && cost + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = cost + weight;
                    pq.offer(new int[]{dist[v][nextCount], v, nextCount});
                }
            }
        }

        return -1;
    }
}