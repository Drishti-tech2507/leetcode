class Solution {
    public boolean canAliceWin(int n) {
        int s = 10;
        boolean al = true;
        while (n >= s) {
            n -= s;
            s--;
            al = !al;
        }
        return !al;
    }
}