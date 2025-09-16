class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        // Precompute lowercase and devoweled forms for each word
        String[] lowerWords = new String[n];
        String[] devowelWords = new String[n];

        for (int i = 0; i < n; i++) {
            lowerWords[i] = wordlist[i].toLowerCase();
            devowelWords[i] = devowel(lowerWords[i]);
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            // 1. Exact match
            boolean found = false;
            for (String word : wordlist) {
                if (word.equals(q)) {
                    ans[i] = word;
                    found = true;
                    break;
                }
            }
            if (found) continue;

            // 2. Case-insensitive match
            String lowerQ = q.toLowerCase();
            for (int j = 0; j < n; j++) {
                if (lowerWords[j].equals(lowerQ)) {
                    ans[i] = wordlist[j];
                    found = true;
                    break;
                }
            }
            if (found) continue;

            // 3. Vowel-error match
            String vowQ = devowel(lowerQ);
            for (int j = 0; j < n; j++) {
                if (devowelWords[j].equals(vowQ)) {
                    ans[i] = wordlist[j];
                    found = true;
                    break;
                }
            }
            if (!found) ans[i] = "";
        }
        return ans;
    }

    // Replace vowels with '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}