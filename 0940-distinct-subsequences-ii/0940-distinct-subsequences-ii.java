class Solution {
    public int distinctSubseqII(String s) {
        final long MOD= 1_000_000_007;
        long[] dp = new long[s.length() + 1];
        long[] last = new long[26];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            int index = ch - 'a';
            dp[i] = (2 * dp[i - 1]) % MOD;
            dp[i] = (dp[i] - last[index] + MOD) % MOD;
            last[index] = dp[i - 1];
        }
        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
    }
}