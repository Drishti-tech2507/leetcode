class Solution {
    // Correct name: dirs (for 4 diagonals: TL, TR, BR, BL)
    int[][] dirs = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxlen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxlen = Math.max(maxlen, 1);
                    maxlen = Math.max(maxlen, dfs(i, j, 0, 2, grid, false));
                    maxlen = Math.max(maxlen, dfs(i, j, 1, 2, grid, false));
                    maxlen = Math.max(maxlen, dfs(i, j, 2, 2, grid, false));
                    maxlen = Math.max(maxlen, dfs(i, j, 3, 2, grid, false));
                }
            }
        }
        return maxlen;
    }

    public int dfs(int row, int col, int dir, int nextval, int[][] grid, boolean turn) {
        int i = row + dirs[dir][0];
        int j = col + dirs[dir][1];
        int m = grid.length, n = grid[0].length;

        // fixed bounds check
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != nextval) {
            return 1;
        }

        int straightValue = 1 + dfs(i, j, dir, (nextval == 2 ? 0 : 2), grid, turn);

        int turnValue = 0;
        if (!turn) {
            turnValue = 1 + dfs(i, j, (dir + 1) % 4, (nextval == 2 ? 0 : 2), grid, true);
        }

        return Math.max(straightValue, turnValue);
    }
}