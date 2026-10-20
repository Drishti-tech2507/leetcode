import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Find all divisors of n
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }

        // Check each divisor k
        for (int k : divisors) {
            if (isSortable(nums, n, k)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int n, int k) {
        int prevBlockMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int end = start + k;
            
            // 1. Count cyclic drops within the subarray
            int dropCount = 0;
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = start; i < end; i++) {
                int nextVal = (i == end - 1) ? nums[start] : nums[i + 1];
                if (nums[i] > nextVal) {
                    dropCount++;
                }
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }

            // More than 1 drop means the block cannot be sorted via rotation
            if (dropCount > 1) {
                return false;
            }

            // 2. Ensure global non-decreasing ordering across adjacent blocks
            if (minVal < prevBlockMax) {
                return false;
            }

            prevBlockMax = maxVal;
        }

        return true;
    }
}