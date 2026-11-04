class Solution {
    public long minOperations(int[] nums, int x, int k) {
       int n = nums.length;

        int[] a = nums.clone();

        Arrays.sort(a);

        int m = 0;

        for (int v : a)

            if (m == 0 || a[m - 1] != v) a[m++] = v;

        long[] cost = new long[n - x + 1];

        long[] cnt = new long[m + 1], sum = new long[m + 1];

        int[] id = new int[n];

        for (int i = 0; i < n; i++)

            id[i] = Arrays.binarySearch(a, 0, m, nums[i]) + 1;

        long total = 0;

        for (int i = 0; i < x; i++) {

            add(cnt, id[i], 1);

            add(sum, id[i], nums[i]);

            total += nums[i];

        }

        for (int i = 0; i <= n - x; i++) {

            int l = 1, r = m, med = 0;

            while (l <= r) {

                int mid = (l + r) / 2;

                if (query(cnt, mid) >= (x + 1) / 2) {

                    med = mid;

                    r = mid - 1;

                } else l = mid + 1;

            }

            long c = query(cnt, med), s = query(sum, med);

            long v = a[med - 1];

            cost[i] = v * c - s + (total - s) - v * (x - c);

            if (i < n - x) {

                add(cnt, id[i], -1);

                add(sum, id[i], -nums[i]);

                add(cnt, id[i + x], 1);

                add(sum, id[i + x], nums[i + x]);

                total += (long) nums[i + x] - nums[i];

            }

        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(dp[j], INF);

            for (int i = 1; i <= n; i++) {

                dp[j][i] = dp[j][i - 1];

                if (i >= x && dp[j - 1][i - x] != INF)

                    dp[j][i] = Math.min(dp[j][i],

                        dp[j - 1][i - x] + cost[i - x]);

            }

        }

        return dp[k][n];

    }

    void add(long[] bit, int i, long v) {

        while (i < bit.length) {

            bit[i] += v;

            i += i & -i;

        }

    }

    long query(long[] bit, int i) {

        long s = 0;

        while (i > 0) {

            s += bit[i];

            i -= i & -i;

        }

        return s;
    }
}