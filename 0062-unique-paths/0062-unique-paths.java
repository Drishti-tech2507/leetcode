class Solution {
    public int uniquePaths(int m, int n) {
        int[][] bp = new int[m][n];
        int i, j;
        for(i = 0; i < m; i++)
        {
            bp[i][0] = 1;
        }
        for(j = 0; j < n; j++)
        {
            bp[0][j] = 1;
        }
        for(i = 1; i < m; i++)
        {
            for(j = 1; j < n; j++)
            {
                bp[i][j] = bp[i - 1][j] + bp[i][j - 1];
            }
        }
        return bp[m - 1][n - 1];
    }
}