class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int in = 0;
        int n = chars.length;
        while (i < n)
        {
            char current = chars[i];
            int c = 0;
            while (i < n && chars[i] == current)
            {
                c++;
                i++;
            }
            chars[in++] = current;
            if (c > 1)
            {
                String num =  String.valueOf(c);
                for (char a : num.toCharArray())
                {
                    chars[in++] = a;
                }
            }
        }
        return in;
    }
}