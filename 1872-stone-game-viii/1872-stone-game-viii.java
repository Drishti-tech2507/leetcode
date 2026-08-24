class Solution {
    public int stoneGameVIII(int[] stones) {
        int s = stones.length;
        int[] pref = new int[s];
        pref[0] = stones[0];
         for(int i = 1; i < s; i++)
          {
            pref[i] = pref[i - 1] + stones[i];
          }
        int dp = pref[s - 1];
        for (int i = s - 2; i >= 1; i--)
        {
        
            dp = Math.max(dp, pref[i] - dp);
        }
        return dp;
    }
}