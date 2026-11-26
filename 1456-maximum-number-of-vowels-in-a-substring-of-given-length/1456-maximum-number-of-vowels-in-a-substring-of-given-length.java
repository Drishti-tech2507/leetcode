class Solution {
    public int maxVowels(String s, int k) {
        int maxV = 0;
        int c = 0;
        for (int i = 0; i < k; i++)
        {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                c++;
            }
        }
        maxV = c;
        for (int i = k; i < s.length(); i++)
        {
           char add = s.charAt(i);
            if (add == 'a' || add == 'e' || add == 'i' || add == 'o' || add == 'u'){
                c++;
            }
            char remove = s.charAt(i - k);
            if (remove == 'a' || remove == 'e' || remove == 'i' || remove == 'o' || remove == 'u')
            {
                c--;
            }
            maxV = Math.max(maxV, c);
        }
        return maxV;
    }
}