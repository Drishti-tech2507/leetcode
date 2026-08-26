class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int c = 0;
        String ans = "";
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '1') {
                c++;
            }

            while (c == k) {
                while (l <= r && s.charAt(l) == '0') {
                    l++;
                }
                String current = s.substring(l, r + 1);
                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length() &&
                     current.compareTo(ans) < 0)) {
                    ans = current;
                }
                if (s.charAt(l) == '1') {
                    c--;
                    l++;
                }

            }
        }
        return ans;
    }
}