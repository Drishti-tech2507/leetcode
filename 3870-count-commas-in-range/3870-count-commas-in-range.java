class Solution {
    public int countCommas(int n) {
        int c = 0;
        for (int i = 1000; i <= n; i++)
        {
            int x = i;
            while (x >= 1000)
            {
                c++;
                x /= 1000;
            }
        }
        return c;
    }
}