class Solution {

    int totalw = 0;

    public int totalNQueens(int n) {

        char[][] b = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                b[i][j] = '.';
            }
        }

        solveBoard(b, 0, n);

        return totalw;
    }

    private void solveBoard(char[][] b, int r, int n) {

        if(r == n) {
            totalw++;
            return;
        }

        for(int c = 0; c < n; c++) {

            if(canPlace(b, r, c, n)) {

                b[r][c] = 'Q';

                solveBoard(b, r + 1, n);

                b[r][c] = '.';
            }
        }
    }

    private boolean canPlace(char[][] b, int r, int c, int n) {
        for(int i = r - 1; i >= 0; i--) {
            if(b[i][c] == 'Q') {
                return false;
            }
        }
        int i = r - 1;
        int j = c - 1;

        while(i >= 0 && j >= 0) {

            if(b[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }
        i = r - 1;
        j = c + 1;

        while(i >= 0 && j < n) {

            if(b[i][j] == 'Q') {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}