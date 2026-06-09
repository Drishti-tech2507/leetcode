class Solution {
    public int bulbSwitch(int n) {
        int c = 0;
        int o = 1;
        while(n >= o)
        {
            n -= o;
            o += 2;
            c++;
        }
        return c;
    }
}