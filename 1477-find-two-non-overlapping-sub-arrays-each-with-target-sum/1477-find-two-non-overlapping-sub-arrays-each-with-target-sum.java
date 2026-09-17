import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // ending at or before index i
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum before index 0
        map.put(0, -1);

        int prefixSum = 0;
        int answer = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            // Find a subarray whose sum is target
            if (map.containsKey(prefixSum - target)) {

                int start = map.get(prefixSum - target);

                int length = i - start;

                // Check for a previous non-overlapping subarray
                if (start >= 0 && best[start] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        length + best[start]
                    );
                }

                // Keep minimum length found so far
                minLength = Math.min(minLength, length);
            }

            best[i] = minLength;

            // Store prefix sum and its latest index
            map.put(prefixSum, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}