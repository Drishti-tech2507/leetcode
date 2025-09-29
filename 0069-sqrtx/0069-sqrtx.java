class Solution {
    public int mySqrt(int x) {
        if(x < 2)return x;
        int l = 1, r = x/2, a = 0;
        while(l <= r)
        {
            int m = l + (r - l)/2;
            if((long) m * m <= x)
            {
                a = m;
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }
        return a;
    }
}