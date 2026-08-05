class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];

        List<Integer>[] reverse = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();

            reverse[i] = new ArrayList<>();

        }

        // Build graph

        for (int[] edge : invocations) {

            graph[edge[0]].add(edge[1]);

            reverse[edge[1]].add(edge[0]);

        }

        // Find all suspicious methods reachable from k

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        // Check if any non-suspicious method calls a suspicious method

        for (int i = 0; i < n; i++) {

            if (!suspicious[i]) {

                for (int next : graph[i]) {

                    if (suspicious[next]) {

                        List<Integer> ans = new ArrayList<>();

                        for (int j = 0; j < n; j++) {

                            ans.add(j);

                        }

                        return ans;

                    }

                }

            }

        }

        // Remove all suspicious methods

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!suspicious[i]) {

                ans.add(i);

            }

        }

        return ans;

    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited) {

        if (visited[node]) return;

        visited[node] = true;

        for (int next : graph[node]) {

            dfs(next, graph, visited);

        }
    }
}