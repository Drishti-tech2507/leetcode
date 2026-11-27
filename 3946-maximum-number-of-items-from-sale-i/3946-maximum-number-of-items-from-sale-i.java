class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        // Count free items for each item type
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        int ans = 0;

        // Try every distinct price as the minimum purchased price
        boolean[] visited = new boolean[1501];

        for (int i = 0; i < n; i++) {
            int p = items[i][1];

            if (visited[p] || p > budget) continue;
            visited[p] = true;

            // dp0: No item of price p selected
            // dp1: At least one item of price p selected
            int[] dp0 = new int[budget + 1];
            int[] dp1 = new int[budget + 1];

            java.util.Arrays.fill(dp0, -1000000);
            java.util.Arrays.fill(dp1, -1000000);

            dp0[0] = 0;

            for (int j = 0; j < n; j++) {
                int cost = items[j][1];

                if (cost < p) continue;

                int value = 1 + free[j];

                for (int b = budget; b >= cost; b--) {
                    if (items[j][1] == p) {
                        dp1[b] = Math.max(dp1[b],
                                dp1[b - cost] + value);

                        dp1[b] = Math.max(dp1[b],
                                dp0[b - cost] + value);
                    } else {
                        dp1[b] = Math.max(dp1[b],
                                dp1[b - cost] + value);

                        dp0[b] = Math.max(dp0[b],
                                dp0[b - cost] + value);
                    }
                }
            }

            // Add extra copies of the cheapest selected item
            for (int b = 0; b <= budget; b++) {
                if (dp1[b] >= 0) {
                    ans = Math.max(ans,
                            dp1[b] + (budget - b) / p);
                }
            }
        }

        return ans;
    }
}