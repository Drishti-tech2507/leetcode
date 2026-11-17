import java.util.*;

class Solution {
public int minimumChanges(String s, int k) {

    int n = s.length();
    int[][] cs = new int[n][n];
    // Precompute minimum changes for every substring
    for (int len = 2; len <= n; len++) {
        for (int l = 0; l + len <= n; l++) {
            int r = l + len - 1;
            int minC = Integer.MAX_VALUE;
            for (int d = 1; d < len; d++) {
                if (len % d != 0) {
                    continue;
                }
                int changes = 0;
                for (int st = 0; st < d; st++) {
                    int left = st;
                    int right = st + ((len - 1 - st) / d) * d;
                    while (left < right) {
                        if (s.charAt(l + left) != s.charAt(l + right)) {
                            changes++;
                        }
                        left += d;
                        right -= d;
                    }
                }
                minC = Math.min(minC, changes);
            }
            cs[l][r] = minC;
        }
    }
    // Dynamic Programming
    int INF = 1000000000;
    int[][] dp = new int[n + 1][k + 1];
    for (int[] row : dp) {
        Arrays.fill(row, INF);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
            for (int p = 0; p < i; p++) {
                int len = i - p;
                if (len < 2 || dp[p][j - 1] == INF) {
                    continue;
                }
                dp[i][j] = Math.min(
                    dp[i][j],
                    dp[p][j - 1] + cs[p][i - 1]
                );
            }
        }
    }
    return dp[n][k];
}

}