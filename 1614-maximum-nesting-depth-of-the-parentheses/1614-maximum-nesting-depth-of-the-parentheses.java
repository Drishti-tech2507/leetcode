class Solution {
    public int maxDepth(String s) {
        int d = 0;
        int maxd = 0;
        for (char ch : s.toCharArray())
        {
            if (ch == '(') {
                d++;
                maxd = Math.max(maxd, d);
            }
            else if (ch == ')')
            {
                d--;
            }
        }
        return maxd;
    }
}