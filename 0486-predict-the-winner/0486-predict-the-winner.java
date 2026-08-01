class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] np = new int[n][n];
        for(int i = 0; i < n; i++) {
            np[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++)
        {
            for (int i = 0; i <= n - len; i++)
            {
                int j = i + len - 1;
                int pickL = nums[i] - np[i + 1][j];
                int pickR = nums[j] - np[i][j - 1];
                np[i][j] = Math.max(pickL, pickR);
            }
        }
        return np[0][n - 1] >= 0;
    }
}