class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // last[j] stores the maximum index in word1 from which word2[j...m-1] 
        // can be matched with 0 mismatches.
        int[] last = new int[m];
        int idx = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (idx >= 0 && word1.charAt(idx) != word2.charAt(j)) {
                idx--;
            }
            last[j] = idx;
            if (idx >= 0) {
                idx--;
            }
        }
        
        int[] ans = new int[m];
        boolean usedMismatch = false;
        int w1Idx = 0;
        
        for (int i = 0; i < m; i++) {
            boolean found = false;
            
            while (w1Idx < n) {
                boolean isMatch = (word1.charAt(w1Idx) == word2.charAt(i));
                
                if (usedMismatch) {
                    // Must match character exactly and ensure remaining suffix can be matched
                    if (isMatch) {
                        if (i == m - 1 || w1Idx < last[i + 1]) {
                            ans[i] = w1Idx;
                            found = true;
                            w1Idx++;
                            break;
                        }
                    }
                } else {
                    // Mismatch not used yet
                    if (i == m - 1 || w1Idx < last[i + 1]) {
                        // Remaining suffix can be matched with 0 mismatches.
                        // We can take w1Idx whether it matches or not.
                        if (!isMatch) {
                            usedMismatch = true;
                        }
                        ans[i] = w1Idx;
                        found = true;
                        w1Idx++;
                        break;
                    } else {
                        // Remaining suffix cannot be matched with 0 mismatches.
                        // We must match character exactly here to preserve mismatch for later.
                        if (isMatch) {
                            ans[i] = w1Idx;
                            found = true;
                            w1Idx++;
                            break;
                        }
                    }
                }
                
                w1Idx++;
            }
            
            if (!found) {
                return new int[0];
            }
        }
        
        return ans;
    }
}