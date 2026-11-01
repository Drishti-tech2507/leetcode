class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int minM = nums[0];
        int s = 0;
        for(int num : nums)
        {
            minM = Math.min(minM, num);
            s += num;
        }
        return s - (n * minM);
    }
}