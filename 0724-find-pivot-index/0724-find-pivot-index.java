class Solution {
    public int pivotIndex(int[] nums) {
        int totalS = 0, leftS = 0;
        for (int i = 0; i < nums.length; i++)
        {
            totalS += nums[i];
        }
         for(int i = 0; i < nums.length; i++){
            int rightS = totalS - leftS - nums[i];
            if (leftS == rightS)
            {
                return i;
            }
            leftS += nums[i];
        }
        return -1;
    }
}