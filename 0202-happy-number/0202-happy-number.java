class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();
        while(n != 1 && !s.contains(n))
        {
            s.add(n);
            n = getS(n);
        }
        return n == 1;
    }
    private int getS(int n)
    {
        int su = 0;
        while(n > 0){
        int d = n % 10;
        su += d * d;
        n = n / 10;
        }
    return su;
    }
}