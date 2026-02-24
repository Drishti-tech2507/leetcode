class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int s = 0;
        for(int i = 0; i < n; i += 2)
        {
            s += nums[i];
        }
        return s;
    }
}