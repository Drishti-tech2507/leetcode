class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;
        int w = 0;
        while(l < r)
        {
            if(height[l] < height[r])
            {
                if(height[l] >= lMax)
                {
                    lMax = height[l];
                }
                else
                {
                    w += lMax - height[l];
                }
                l++;
            }
            else
            {
                if(height[r] >= rMax)
                {
                    rMax = height[r];
                }
                else
                {
                    w += rMax - height[r];
                }
                r--;
            }
        }
        return w;
    }
}