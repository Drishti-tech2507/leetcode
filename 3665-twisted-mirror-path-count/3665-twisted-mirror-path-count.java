class Solution {
    public int uniquePaths(int[][] grid) {
         int m = grid.length;

        int n = grid[0].length;

        long MOD = 1000000007;

        long[][] right = new long[m][n];

        long[][] down = new long[m][n];

        // Starting position

        right[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                long r = right[i][j];

                long d = down[i][j];

                if (grid[i][j] == 0) {

                    // Empty cell: move right

                    if (j + 1 < n) {

                        right[i][j + 1] =

                            (right[i][j + 1] + r + d) % MOD;

                    }

                    // Empty cell: move down

                    if (i + 1 < m) {

                        down[i + 1][j] =

                            (down[i + 1][j] + r + d) % MOD;

                    }

                } else {

                    // Mirror: entered while moving right

                    // Reflection sends robot down

                    if (i + 1 < m) {

                        down[i + 1][j] =

                            (down[i + 1][j] + r) % MOD;

                    }

                    // Mirror: entered while moving down

                    // Reflection sends robot right

                    if (j + 1 < n) {

                        right[i][j + 1] =

                            (right[i][j + 1] + d) % MOD;

                    }

                }

            }

        }

        return (int) ((right[m - 1][n - 1]

                     + down[m - 1][n - 1]) % MOD);
    }
}