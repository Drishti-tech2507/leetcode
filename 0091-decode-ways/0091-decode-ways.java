class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int[] np = new int[n + 1];
        np[0] = 1;
        np[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            if(s.charAt(i-1) != '0')
            {
                np[i] += np[i - 1];
            }
            int td = Integer.parseInt(s.substring(i - 2, i));
            if(td >= 10 && td <= 26)
            {
                np[i] += np[i - 2];
            }
        }
        return np[n];
    }
}