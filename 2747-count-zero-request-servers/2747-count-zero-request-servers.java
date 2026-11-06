class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
         Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;

        // Store queries with their original indices

        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {

            q[i][0] = queries[i];

            q[i][1] = i;

        }

        // Sort queries by time

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[m];

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;

        int right = 0;

        int activeServers = 0;

        for (int i = 0; i < m; i++) {

            int currQuery = q[i][0];

            int start = currQuery - x;

            // Add logs within the current query's right boundary

            while (right < logs.length &&

                   logs[right][1] <= currQuery) {

                int server = logs[right][0];

                if (!map.containsKey(server)) {

                    activeServers++;

                }

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;

            }

            // Remove logs outside the current window

            while (left < right &&

                   logs[left][1] < start) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                    activeServers--;

                }

                left++;

            }

            // Number of inactive servers
            ans[q[i][1]] = n - activeServers;

        }

        return ans;
    }
}