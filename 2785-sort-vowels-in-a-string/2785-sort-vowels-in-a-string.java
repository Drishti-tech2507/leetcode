class Solution {
     private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    public String sortVowels(String s) {
         char[] arr = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        // Step 1: collect vowels
        for (char c : arr) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: sort vowels
        Collections.sort(vowels);

        // Step 3: rebuild string with sorted vowels
        StringBuilder result = new StringBuilder();
        int idx = 0; // vowel index
        for (char c : arr) {
            if (isVowel(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}