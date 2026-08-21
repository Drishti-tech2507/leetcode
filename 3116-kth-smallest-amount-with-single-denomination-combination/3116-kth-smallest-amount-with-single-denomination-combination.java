class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 1;
        long h = (long) coins[0] * k;
        for(int coin : coins)
        {
            h = Math.min(h, (long) coin * k);
        }
        while (l < h)
        {
            long m = l + (h - l) / 2;
            if (count(m, coins) >= k)
            {
                h = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
    private long count(long x, int[] coins)
    {
        long res = 0;
        int n = coins.length;
        for (int mask = 1; mask < (1 << n); mask++)
        {
            long lcm = 1;
            boolean ovf = false;
            int bits = 0;
            for (int i = 0; i < n; i++)
            {
                if((mask & (1 << i)) != 0)
                {
                    bits++;
                    long gcd = gcd(lcm, coins[i]);
                    long v = lcm / gcd;
                    if (v > x / coins[i])
                    {
                        ovf = true;
                        break;
                    }
                    lcm = v * coins[i];
                }
            }
            if (!ovf)
            {
                long cnt = x / lcm;
                if (bits % 2 == 1) {
                    res += cnt;
                }
                else {
                    res -= cnt;
                }
            }
        }
        return res;
    }
    private long gcd(long a, long b)
    {
        while (b != 0)
        {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}