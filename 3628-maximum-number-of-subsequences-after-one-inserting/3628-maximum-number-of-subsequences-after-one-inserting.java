class Solution {
    public long numOfSubsequences(String s) {

        int n = s.length();

        long countL = 0;
        long countLC = 0;
        long countLCT = 0;

        // Count existing LCT
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'L')
                countL++;
            else if (ch == 'C')
                countLC += countL;
            else if (ch == 'T')
                countLCT += countLC;
        }

        // Insert L: Count CT
        long countT = 0;
        long countCT = 0;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == 'T')
                countT++;
            else if (ch == 'C')
                countCT += countT;
        }

        // Insert T: Count LC
        long countLC2 = 0;
        long totalL = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'L')
                totalL++;
            else if (ch == 'C')
                countLC2 += totalL;
        }

        // Insert C: Prefix L * Suffix T
        long prefixL = 0;
        long maxC = 0;

        long[] suffixT = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixT[i] = suffixT[i + 1];

            if (s.charAt(i) == 'T')
                suffixT[i]++;
        }

        for (int i = 0; i <= n; i++) {

            maxC = Math.max(maxC, prefixL * suffixT[i]);

            if (i < n && s.charAt(i) == 'L')
                prefixL++;
        }

        long best = Math.max(countCT,
                    Math.max(countLC2, maxC));

        return countLCT + best;
    }
}