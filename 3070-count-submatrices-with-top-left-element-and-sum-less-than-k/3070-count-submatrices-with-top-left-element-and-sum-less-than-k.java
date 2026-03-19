class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] p = new int[m][n];
        int c = 0;
        int i, j;
        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                p[i][j] = grid[i][j];
                if(i > 0)
                {
                    p[i][j] += p[i - 1][j];
                }
                if(j > 0)
                {
                    p[i][j] += p[i][j - 1];

                }
                if(i > 0 && j > 0)
                {
                    p[i][j] -= p[i - 1][j - 1];
                }
                if(p[i][j] <= k)
                {
                    c++;
                }
            }
        }
        return c;

    }
}