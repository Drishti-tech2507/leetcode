class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            long prod = 1;
            int g = 0, l = 1;
            for (int j = i; j < n; j++)
            {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                if (prod == (long) l * g) {

                    ans = Math.max(ans, j - i + 1);

                }

            }

        }

        return ans;

    }

    int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);

    }

    int lcm(int a, int b) {

        return (a / gcd(a, b)) * b;
    }
}