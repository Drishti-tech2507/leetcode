class Solution {
    public int[] closestDivisors(int num) {
        int c = 0;
        int[] a1 = findClosest(num + 1);
        int[] a2 = findClosest(num + 2);

        int d1 = Math.abs(a1[0] - a1[1]);
        int d2 = Math.abs(a2[0] - a2[1]);
        return d1 <= d2 ? a1 : a2;    
    }
    private int[] findClosest(int n)
    {
        for(int i = (int)Math.sqrt(n); i >= 1; i--)
        {
            if(n % i == 0)
            {
                return new int[]{i, n / i};
            }
        }
        return new int[]{1, n};
    }
}