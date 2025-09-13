class Solution {
    public int maxFreqSum(String s) {
        if(s == null || s. isEmpty())return 0;
        int[]freq = new int[26];
        String vowels = "aeiou";
        for(char ch: s.toCharArray())
        {
            if(Character. isLetter(ch))
            {
                char lower = Character.toLowerCase(ch);
                freq[lower - 'a']++;
            }
        }
        int maxVowel = 0;
        for(char v: vowels.toCharArray())
        {
            maxVowel = Math.max(maxVowel, freq[v-'a']);
        }
        int maxConsonant = 0;
        for(char c = 'a'; c <= 'z'; c++)
        {
            if(vowels.indexOf(c) >= 0)continue;
            maxConsonant = Math.max(maxConsonant, freq[c-'a']);
        }
        return maxVowel + maxConsonant;
    }
}