class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(),  m = p.length();
        boolean[][] bp = new boolean[n + 1][m + 1];
        bp[0][0] = true;
        for(int j = 1; j <= m; j++)
        {
            if(p.charAt(j - 1) == '*')
            {
                bp[0][j] = bp[0][j - 1];
            }
        }
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if(pc == sc || pc == '?')
                {
                    bp[i][j] = bp[i - 1][j - 1];
                }
                else if (pc == '*')
                {
                    bp[i][j] = bp[i][j - 1] || bp[i - 1][j];
                }
                else
                {
                    bp[i][j] = false;
                }
            }
        }
        return bp[n][m];
    }
}