class Solution {
    public int largestAltitude(int[] gain) {
        int alti = 0, maxA = 0;
        int g = gain.length;
        for (int i = 0; i < g; i++)
        {
            alti = alti + gain[i];
            maxA = Math.max(maxA, alti);
        }
        return maxA;
    }
}