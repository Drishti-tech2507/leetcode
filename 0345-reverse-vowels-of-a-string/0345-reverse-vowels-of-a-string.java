class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r)
        {
             while (l < r && !isVowel(arr[l]))
             {
                l++;
             }
             while (l < r && !isVowel(arr[r]))
             {
                r--;
             }
             char temp = arr[l];
             arr[l] = arr[r];
             arr[r] = temp;
             l++;
             r--;
        }
        return new String(arr);
    }
    private boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}