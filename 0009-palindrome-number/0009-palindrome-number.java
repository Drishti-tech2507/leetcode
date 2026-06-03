class Solution {
    public boolean isPalindrome(int x) {
       int rev=0,n, p = x;
        while(x>0)
        {
            n = x%10;
            rev=(rev*10)+n;
            x = x/10;
        }
        return rev==p;
    }
}