class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, maxL = 0, z = 0;
        for (int r = 0; r < n; r++)
        {
            if (nums[r] == 0)
            {
                z++;
            }
            while (z > k)
            {
                if (nums[l] == 0)
                {
                    z--;
                }
                l++;
            }
            int len = r - l + 1;
            maxL = Math.max(maxL,len);
        }
        return maxL;
    }
}