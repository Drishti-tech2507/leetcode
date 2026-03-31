class Solution {
    public int numTrees(int n) {
         int[] bp = new int[n + 1];
        bp[0] = 1;
        bp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            for(int r = 1; r <= i; r++)
            {
                int l = r - 1;
                int rt = i - r;

                bp[i] += bp[l] * bp[rt];
            }
        }
        return bp[n];
    }
}