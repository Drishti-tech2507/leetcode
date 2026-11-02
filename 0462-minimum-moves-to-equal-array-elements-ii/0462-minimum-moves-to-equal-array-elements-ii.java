class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];
        int minM2 = 0;
        int s = 0;
        for (int num : nums)
        {
            minM2 += Math.abs(num - median);
        }
        return minM2;
    }
}