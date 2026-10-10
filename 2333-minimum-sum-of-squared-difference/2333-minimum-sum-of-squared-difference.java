class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;
        long sum = 0;

        // Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += (long) diff[i] * diff[i];
        }

        // If we can eliminate all differences
        if (sum == 0 || k >= sum) {
            // Note: sum is not the number of operations required.
            // The correct all-zero check is handled below.
        }

        long totalDiff = 0;
        for (int d : diff) {
            totalDiff += d;
        }

        if (k >= totalDiff) {
            return 0;
        }

        // Binary search for the minimum possible maximum difference
        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Reduce all differences to at most 'left'
        long answer = 0;
        long remaining = k;

        for (int d : diff) {
            int reduced = Math.min(d, left);
            answer += (long) reduced * reduced;
            remaining -= d - reduced;
        }

        // Distribute remaining operations to reduce differences further
        // Differences currently equal to 'left' can be reduced by one.
        if (left > 0 && remaining > 0) {
            for (int d : diff) {
                if (d >= left && remaining > 0) {
                    answer -= (long) left * left
                            - (long) (left - 1) * (left - 1);
                    remaining--;
                }
            }
        }

        return answer;
    }
}