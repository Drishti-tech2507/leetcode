class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>seen = new HashSet<>();
        while(n != 1 && ! seen.contains(n))
        {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }
    private int getSumOfSquares(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            int d = num % 10;
            sum += d * d;
            num /= 10;
        }
        return sum;
    }
}