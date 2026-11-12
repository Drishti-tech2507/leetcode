class Solution {
    public boolean increasingTriplet(int[] nums) {
        int f = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE;
        for (int num : nums)
        {
            if (num <= f)
            {
                f = num;
            }
            else if (num <= l)
            {
                l = num;
            }
            else {
                return true;
            }
        }
        return false;
    }
}