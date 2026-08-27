class Solution {
    public String lexGreaterPermutation(String s, String target) {
    int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[n];
        int L = 0;

        // Step 1: Build the maximum possible matching prefix with target
        while (L < n) {
            int c = target.charAt(L) - 'a';
            if (freq[c] > 0) {
                ans[L] = target.charAt(L);
                freq[c]--;
                L++;
            } else {
                break;
            }
        }

        // Step 2: Backtrack from L down to 0 to find the first position where
        // we can place a character strictly greater than target.charAt(i)
        for (int i = L; i >= 0; i--) {
            // When backtracking past L, return target.charAt(i) to frequency pool
            if (i < L) {
                freq[ans[i] - 'a']++;
            }

            int targetChar = (i < n) ? (target.charAt(i) - 'a') : -1;

            // Find the smallest character greater than target.charAt(i)
            for (int nextChar = targetChar + 1; nextChar < 26; nextChar++) {
                if (freq[nextChar] > 0) {
                    ans[i] = (char) ('a' + nextChar);
                    freq[nextChar]--;
                    int pos = i + 1;
                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[pos++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }
                    return new String(ans);
                }
            }
        }

        return "";

    }

}