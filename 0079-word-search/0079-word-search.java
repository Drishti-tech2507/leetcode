class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if (dfs(board, word, i, j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int id) {

        if (id == word.length()) {

            return true;
        }
        if (r < 0 || c < 0 ||

            r >= board.length || c >= board[0].length ||

            board[r][c] != word.charAt(id)) {

            return false;

        }

        char temp = board[r][c];

        board[r][c] = '#';

        boolean f =

                dfs(board, word, r + 1, c, id + 1) ||

                dfs(board, word, r - 1, c, id+ 1) ||

                dfs(board, word, r, c + 1, id+ 1) ||

                dfs(board, word, r, c - 1, id + 1);

        board[r][c] = temp;

        return f;

    }
}