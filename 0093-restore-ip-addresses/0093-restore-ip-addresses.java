class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<>();
        backtrack(s, 0, 0, "", r);
        return r;
    }
    private void backtrack(String s, int in, int p, String curr, List<String> r)
    {
        if (p == 4 && in == s.length())
        {
            r.add(curr.substring(0, curr.length() - 1));
            return;
        }
        if(p == 4 || in == s.length())
        {
            return;
        }
        for (int l = 1; l <= 3 && in + l <= s.length(); l++)
        {
            String pt = s.substring(in, in + l);
            if (pt.length() > 1 && pt.charAt(0) == '0')
            {
                continue;
            }
            int num = Integer.parseInt(pt);
            if(num >= 0 && num <= 255)
            {
                backtrack(s, in + l, p + 1, curr + pt + ".", r);
            }
        }
    }
}