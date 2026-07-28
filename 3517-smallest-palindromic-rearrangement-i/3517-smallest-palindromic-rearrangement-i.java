class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
        {
            freq[ch - 'a']++;
        }
        StringBuilder firH = new StringBuilder();
        String mid = "";
        
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] % 2 == 1)
            {
                mid = String.valueOf((char) ('a' + i));
            }
            for (int j = 0; j < freq[i] / 2; j++)
            {
                firH.append((char) ('a' + i));
            }
        }
        String secH = new StringBuilder(firH).reverse().toString();
        return firH.toString() + mid + secH;
    }
}