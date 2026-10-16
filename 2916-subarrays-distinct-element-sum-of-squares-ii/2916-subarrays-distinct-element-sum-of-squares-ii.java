import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MOD = 1_000_000_007;

    private static class SegmentTree {
        int n;
        long[] sum;
        long[] sqSum;
        long[] lazy;

        public SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void pushDown(int node, int start, int end) {
            if (lazy[node] == 0) return;

            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            applyAdd(leftChild, start, mid, lazy[node]);
            applyAdd(rightChild, mid + 1, end, lazy[node]);

            lazy[node] = 0;
        }

        private void applyAdd(int node, int start, int end, long val) {
            long len = end - start + 1;
            // (x + v)^2 = x^2 + 2 * v * x + v^2
            sqSum[node] = (sqSum[node] + 2 * val % MOD * sum[node] % MOD + len * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + len * val % MOD) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        public void updateRange(int node, int start, int end, int l, int r, long val) {
            if (r < start || end < l) return;

            if (l <= start && end <= r) {
                applyAdd(node, start, end, val);
                return;
            }

            pushDown(node, start, end);
            int mid = start + (end - start) / 2;
            updateRange(2 * node + 1, start, mid, l, r, val);
            updateRange(2 * node + 2, mid + 1, end, l, r, val);

            sum[node] = (sum[2 * node + 1] + sum[2 * node + 2]) % MOD;
            sqSum[node] = (sqSum[2 * node + 1] + sqSum[2 * node + 2]) % MOD;
        }

        public long querySqSum() {
            return sqSum[0];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int prevIdx = lastSeen.getOrDefault(val, -1);

            // Increment distinct count for all subarrays starting from (prevIdx + 1) to j
            tree.updateRange(0, 0, n - 1, prevIdx + 1, j, 1);

            // Add sum of squares of distinct counts ending at index j
            totalSum = (totalSum + tree.querySqSum()) % MOD;

            // Update last seen position
            lastSeen.put(val, j);
        }

        return (int) totalSum;
    }
}