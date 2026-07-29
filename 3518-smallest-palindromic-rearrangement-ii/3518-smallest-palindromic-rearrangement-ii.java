class Solution {
    // k is bounded (k <= 10^6), capping combinations at 1,000,001 is sufficient
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char mid = 0;
        int[] half = new int[26];
        int m = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
            half[i] = freq[i] / 2;
            m += half[i];
        }

        // If total possible palindromes < k, return empty string
        if (count(half, m) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < m; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = count(half, m - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long count(int[] half, int total) {
        long res = 1;
        int remaining = total;

        for (int i = 0; i < 26; i++) {
            int c = half[i];
            if (c == 0) continue;

            // Multiply combinations incrementally to avoid overflow
            for (int j = 1; j <= c; j++) {
                res = res * (remaining - c + j) / j;
                if (res > LIMIT) {
                    res = LIMIT;
                    break;
                }
            }
            if (res >= LIMIT) {
                return LIMIT;
            }
            remaining -= c;
        }

        return res;
    }
}