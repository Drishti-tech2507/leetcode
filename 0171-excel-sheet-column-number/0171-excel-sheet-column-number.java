class Solution {
    public int titleToNumber(String columnTitle) {
        int r = 0;
        for(int i = 0; i < columnTitle.length(); i++)
        {
            char c = columnTitle.charAt(i);
            r = r*26+(c-'A'+1);
        }
        return r;
    }
}