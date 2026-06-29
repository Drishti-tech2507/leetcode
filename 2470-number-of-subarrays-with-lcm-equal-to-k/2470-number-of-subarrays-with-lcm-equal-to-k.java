class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            long lcm = 1;
            for (int j = i; j < n; j++) {
                if (k % nums[j] != 0) {
                    break;
                }
                lcm = lcm(lcm, nums[j]);
                if (lcm == k) {
                    c++;
                }

                if (lcm > k || k % lcm != 0) {
                    break;
                }
            }
        }

        return c;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}