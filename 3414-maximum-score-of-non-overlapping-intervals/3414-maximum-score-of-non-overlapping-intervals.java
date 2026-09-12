import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    private static class DPValue {
        long weight;
        int[] indices;

        DPValue(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        // Sort intervals by start time l
        Arrays.sort(arr, (a, b) -> Integer.compare(a.l, b.l));

        // Binary search for next non-overlapping interval
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            int ans = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid].l > arr[i].r) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        // DP Table: dp[i][k] represents optimal pick from arr[i...n-1] with at most k intervals
        DPValue[][] dp = new DPValue[n + 1][5];

        // Base cases
        DPValue empty = new DPValue(0, new int[0]);
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = empty;
            }
        }

        // Bottom-up Iterative DP
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip arr[i]
                DPValue skip = dp[i + 1][k];

                // Option 2: Pick arr[i]
                DPValue next = dp[nextIdx[i]][k - 1];
                long takeWeight = arr[i].weight + next.weight;
                
                int[] takeIndices = new int[next.indices.length + 1];
                takeIndices[0] = arr[i].id;
                System.arraycopy(next.indices, 0, takeIndices, 1, next.indices.length);
                
                // Sort array to ensure indices in the choice are ordered globally
                Arrays.sort(takeIndices);
                DPValue take = new DPValue(takeWeight, takeIndices);

                // Choose best based on weight first, then lexicographical order
                dp[i][k] = getBest(take, skip);
            }
        }

        return dp[0][4].indices;
    }

    private DPValue getBest(DPValue a, DPValue b) {
        if (a.weight > b.weight) return a;
        if (b.weight > a.weight) return b;

        // Equal weight: pick lexicographically smaller array
        int minLen = Math.min(a.indices.length, b.indices.length);
        for (int i = 0; i < minLen; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i] ? a : b;
            }
        }
        return a.indices.length <= b.indices.length ? a : b;
    }
}