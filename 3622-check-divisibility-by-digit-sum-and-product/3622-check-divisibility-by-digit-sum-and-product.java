class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0, p = 1;
        int rem = n ;

        while (rem > 0)
        {
            int d = rem % 10;

            s = s + d;
            p = p * d;

            rem = rem / 10;
        } 
        if (n % (s + p) == 0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}