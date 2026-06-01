class Solution {
    public int missingNumber(int[] nums) {
        int i;
        int exSum = nums.length * (nums.length + 1) / 2;
        int acSum = 0;
        for(i = 0; i < nums.length; i++)
        {
            int temp = nums[i];
            acSum += temp;
        }
        return exSum - acSum;
    }
}