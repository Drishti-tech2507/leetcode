class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
       int i;
       for(i = 0; i <= n; i++) 
       {
        int f = 0;
        int j;
        for(j = 0; j < n; j++)
        {
            if(nums[j] == i)
            {
                f = 1;
                break;
            }
        }
        if(f == 0) return i;
       }
       return -1;
    }
}