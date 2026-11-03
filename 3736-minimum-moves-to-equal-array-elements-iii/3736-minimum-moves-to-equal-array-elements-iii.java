class Solution {
    public int minMoves(int[] nums) {
        int minM = nums[0];
        int s = 0;
        for (int num : nums)
        {
            minM = Math.max(minM, num);
        }
         for (int num : nums)
        {
            s += minM - num;
        }

        return s;
    }
}