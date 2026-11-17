class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int s = 0;
        for (int i = 0; i < k; i++){
            s += nums[i];
        }
        int maxS = s;
        for (int i = k; i < nums.length; i++)
        {
            s += nums[i];
            s -= nums[i - k];
            maxS = Math.max(maxS, s);
        }
        return (double)maxS / k;
    }
}