class Solution {
    public int maxSubArray(int[] nums) {
        int cs = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            cs = Math.max(nums[i], cs + nums[i]);
            maxSum = Math.max(maxSum, cs);
        }
        return maxSum;
    }
}