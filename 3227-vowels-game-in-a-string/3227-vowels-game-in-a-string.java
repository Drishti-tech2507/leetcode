class Solution {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = Character.toLowerCase(s.charAt(i));
            if(isVowel(c))
            {
                vowelCount++;
            }
        }
        return vowelCount > 0;
    }
    private boolean isVowel(char c)
    {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}