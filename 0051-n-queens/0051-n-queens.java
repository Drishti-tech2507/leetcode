class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2*n-1];
        boolean[] antiDiag = new boolean[2*n-1];
        char[][] board = new char[n][n];
        for(char[] row:board)
        {
            Arrays.fill(row, '.');
        }
   backtrack(0, board, result, col, diag, antiDiag, n);
        return result;
    }
    private void backtrack(int row, char[][] board, List<List<String>> result, boolean[] col, boolean[] diag, boolean[] antiDiag, int n)
    {
        if(row == n)
        {
            List<String> solution = new ArrayList<>();
            for(char[] r : board)
            {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }
        for(int c = 0; c < n; c++)
        {
            if(col[c] || diag[row - c + n - 1] || antiDiag[row + c])
            {
                continue;
            }
            board[row][c] = 'Q';
            col[c] = true;
            diag[row - c + n - 1] = true;
            antiDiag[row + c] = true;
            backtrack(row + 1, board, result, col, diag, antiDiag, n);
            board[row][c] = '.';
            col[c] = false;
            diag[row-c+n-1] = false;
            antiDiag[row+c] = false;
        }
    }
}