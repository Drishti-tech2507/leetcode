class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board)
    {
        for(int r = 0; r < 9; r++)
        {
            for(int c = 0; c < 9; c++)
            {
                if(board[r][c] == '.')
                {
                    for(char ch = '1'; ch <= '9'; ch++)
                    {
                        if(isValid(board, r, c, ch))
                        {
                            board[r][c] = ch;
                            if(backtrack(board))return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char ch)
    {
        for(int i = 0; i < 9; i++)
        {
            if(board[row][i] == ch)return false;
            if(board[i][col] == ch)return false;
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            if(board[r][c] == ch)return false;
        }
        return true;
    }
}