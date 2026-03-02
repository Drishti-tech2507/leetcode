class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2 * n + 1];
    
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = -2;
        }
        
        int c = 0;
        int maxlength = 0;
        
        arr[n] = -1;

        for(int i = 0; i < n; i++)
            {
                if(nums[i] == 0)
                {
                    c += -1;
                }
                else
                {
                    c += 1;
                }
                if(arr[c + n] != -2)
                {
                    maxlength = Math.max(maxlength, i - arr[c + n]);
                }
                else
                {
                    arr[c + n] = i;
                }
            }
        return maxlength;
    }
}