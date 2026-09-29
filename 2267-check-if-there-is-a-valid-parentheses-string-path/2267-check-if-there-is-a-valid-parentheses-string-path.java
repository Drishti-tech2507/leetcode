class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length is m + n - 1. A valid parentheses string must have an even length.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // memo[r][c][balance] stores visited states to avoid redundant computations
        int maxBalance = (m + n) / 2;
        Boolean[][][] memo = new Boolean[m][n][maxBalance + 1];

        return dfs(0, 0, 0, grid, memo, m, n);
    }

    private boolean dfs(int r, int c, int balance, char[][] grid, Boolean[][][] memo, int m, int n) {
        // Update current balance
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid path if closing parentheses exceed opening ones
        if (balance < 0) {
            return false;
        }

        // Maximum possible remaining steps to reach destination
        int maxPossibleBalance = (m - 1 - r) + (n - 1 - c);
        if (balance > maxPossibleBalance) {
            return false;
        }

        // Destination reached: valid if balance is 0
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return memoized result if already evaluated
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(r + 1, c, balance, grid, memo, m, n);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(r, c + 1, balance, grid, memo, m, n);
        }

        return memo[r][c][balance] = found;
    }
}