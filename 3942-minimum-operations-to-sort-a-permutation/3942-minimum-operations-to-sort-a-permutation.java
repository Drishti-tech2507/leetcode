class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {
            if (nums[(idx0 + i) % n] != i) {
                increasing = false;
            }
            if (nums[(idx0 + i) % n] != (n - i) % n) {
                decreasing = false;
            }
        }

        if (increasing) {
            // Path 1: Just rotate left `idx0` times.
            // Path 2: Reverse -> Rotate left -> Reverse.
            return Math.min(idx0, n - idx0 + 2);
        }

        if (decreasing) {
            // Path 1: Reverse first, then rotate left.
            // Path 2: Rotate left first, then reverse.
            return Math.min(n - idx0, ((idx0 + 1) % n) + 1);
        }

        return -1;
    }
}