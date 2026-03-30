class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] bp = new int[m][n];
        if(obstacleGrid[0][0] == 1)return 0;
        bp[0][0] = 1;
          for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {   
                bp[i][0] = bp[i - 1][0];
            } else {
                bp[i][0] = 0;
            }
        }
          for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                bp[0][j] = bp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    bp[i][j] = bp[i - 1][j] + bp[i][j - 1];
                } else {
                    bp[i][j] = 0;
                }
            }
        }
         return bp[m - 1][n - 1];
}
}