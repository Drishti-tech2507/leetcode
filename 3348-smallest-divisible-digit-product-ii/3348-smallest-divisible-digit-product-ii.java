import java.util.Arrays;
class Solution {
    private static int[][] dp = new int[70][50];
    private static boolean dpInitialized = false;

    // Precalculate minimum digits needed for required powers of 2 and 3
    private synchronized static void initDp() {
        if (dpInitialized) return;

        for (int i = 0; i < 70; i++) {
            Arrays.fill(dp[i], 100000);
        }
        dp[0][0] = 0;

        for (int i = 0; i < 70; i++) {
            for (int j = 0; j < 50; j++) {
                if (dp[i][j] == 100000) continue;
                int cur = dp[i][j];

                // Transitions for digits 2, 3, 4, 6, 8, 9
                dp[Math.min(69, i + 1)][j] = Math.min(dp[Math.min(69, i + 1)][j], cur + 1); // 2
                dp[i][Math.min(49, j + 1)] = Math.min(dp[i][Math.min(49, j + 1)], cur + 1); // 3
                dp[Math.min(69, i + 2)][j] = Math.min(dp[Math.min(69, i + 2)][j], cur + 1); // 4
                dp[Math.min(69, i + 1)][Math.min(49, j + 1)] = Math.min(dp[Math.min(69, i + 1)][Math.min(49, j + 1)], cur + 1); // 6
                dp[Math.min(69, i + 3)][j] = Math.min(dp[Math.min(69, i + 3)][j], cur + 1); // 8
                dp[i][Math.min(49, j + 2)] = Math.min(dp[i][Math.min(49, j + 2)], cur + 1); // 9
            }
        }

        // Suffix minimums so dp[i][j] gives answer for AT LEAST i twos and j threes
        for (int i = 69; i >= 0; i--) {
            for (int j = 49; j >= 0; j--) {
                if (i + 1 < 70) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                if (j + 1 < 50) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
            }
        }

        dpInitialized = true;
    }

    private int count2(int d) {
        if (d == 2 || d == 6) return 1;
        if (d == 4) return 2;
        if (d == 8) return 3;
        return 0;
    }

    private int count3(int d) {
        if (d == 3 || d == 6) return 1;
        if (d == 9) return 2;
        return 0;
    }

    private int count5(int d) {
        return d == 5 ? 1 : 0;
    }

    private int count7(int d) {
        return d == 7 ? 1 : 0;
    }

    public String smallestNumber(String num, long t) {
        initDp();

        // 1. Factorize t into prime factors 2, 3, 5, 7
        int reqA = 0, reqB = 0, reqC = 0, reqD = 0;
        long temp = t;
        while (temp % 2 == 0) { reqA++; temp /= 2; }
        while (temp % 3 == 0) { reqB++; temp /= 3; }
        while (temp % 5 == 0) { reqC++; temp /= 5; }
        while (temp % 7 == 0) { reqD++; temp /= 7; }

        // Prime factors > 7 cannot be produced by digits 1-9
        if (temp > 1) return "-1";

        int n = num.length();

        // Find position of first '0'
        int firstZero = n;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                firstZero = i;
                break;
            }
        }

        // Precompute prefix counts of prime factors
        int[] prefA = new int[n + 1];
        int[] prefB = new int[n + 1];
        int[] prefC = new int[n + 1];
        int[] prefD = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            prefA[i + 1] = prefA[i] + count2(d);
            prefB[i + 1] = prefB[i] + count3(d);
            prefC[i + 1] = prefC[i] + count5(d);
            prefD[i + 1] = prefD[i] + count7(d);
        }

        // Case 1: Check if num itself is valid (zero-free and satisfies prime factor requirements)
        if (firstZero == n && prefA[n] >= reqA && prefB[n] >= reqB && prefC[n] >= reqC && prefD[n] >= reqD) {
            return num;
        }

        // Case 2: Try replacing digit at index i with a strictly larger digit
        for (int i = Math.min(n - 1, firstZero); i >= 0; i--) {
            int curA = prefA[i];
            int curB = prefB[i];
            int curC = prefC[i];
            int curD = prefD[i];

            int startDigit = num.charAt(i) - '0' + 1;
            for (int d = startDigit; d <= 9; d++) {
                int remA = Math.max(0, reqA - curA - count2(d));
                int remB = Math.max(0, reqB - curB - count3(d));
                int remC = Math.max(0, reqC - curC - count5(d));
                int remD = Math.max(0, reqD - curD - count7(d));

                int remLen = n - 1 - i;
                if (remC + remD + dp[remA][remB] <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i).append(d);
                    sb.append(fill(remLen, remA, remB, remC, remD));
                    return sb.toString();
                }
            }
        }

        // Case 3: Create a result of length > n
        int minLenForFactors = reqC + reqD + dp[reqA][reqB];
        int targetLen = Math.max(n + 1, minLenForFactors);
        return fill(targetLen, reqA, reqB, reqC, reqD);
    }

    // Greedily constructs the smallest string of length `len` that meets remaining requirements
    private String fill(int len, int reqA, int reqB, int reqC, int reqD) {
        StringBuilder sb = new StringBuilder();
        for (int pos = 0; pos < len; pos++) {
            int remLen = len - 1 - pos;
            for (int d = 1; d <= 9; d++) {
                int nA = Math.max(0, reqA - count2(d));
                int nB = Math.max(0, reqB - count3(d));
                int nC = Math.max(0, reqC - count5(d));
                int nD = Math.max(0, reqD - count7(d));

                if (nC + nD + dp[nA][nB] <= remLen) {
                    sb.append(d);
                    reqA = nA;
                    reqB = nB;
                    reqC = nC;
                    reqD = nD;
                    break;
                }
            }
        }
        return sb.toString();
    }
}