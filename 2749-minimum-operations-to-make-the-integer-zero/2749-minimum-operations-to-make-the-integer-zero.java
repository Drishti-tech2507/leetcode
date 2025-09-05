class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k = 1; k <= 60; k++)
        {
            long remain = (long)num1 - (long)k * num2;
            if(remain < 0)continue;
            int bits = Long.bitCount(remain);
            if(bits <= k && k <= remain)
            {
                return k;
            }
        }
        return -1;
    }
}