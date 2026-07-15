class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n + 1];
        int[] outd = new int[n + 1];
        for (int[] t : trust)
        {
            int a = t[0];
            int b = t[1];
            outd[a]++;
            ind[b]++;
        }
        for(int i = 1; i <= n; i++)
        {
            if (ind[i] == n - 1 && outd[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }
}