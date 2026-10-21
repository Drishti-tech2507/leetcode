import java.util.Arrays;

public class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Step 1: Create the target sorted version of s
        char[] targetArray = s.toCharArray();
        Arrays.sort(targetArray);

        // Step 2: Check if s is already sorted (0 operations)
        boolean isSorted = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != targetArray[i]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }

        // Step 3: Base case for length 2 (1 proper substring operation does nothing)
        if (n == 2) {
            return -1;
        }

        // Step 4: Check if 1 operation is possible.
        // It is possible if either the first character or the last character 
        // is already in its correct sorted position.
        if (s.charAt(0) == targetArray[0] || s.charAt(n - 1) == targetArray[n - 1]) {
            return 1;
        }

        // Step 5: Check if 3 operations are required or 2 operations are enough.
        // 3 operations are required ONLY when s length > 2, the min element is exclusively at s[n-1],
        // and the max element is exclusively at s[0].
        // Otherwise, 2 operations are always sufficient.
        char minChar = targetArray[0];
        char maxChar = targetArray[n - 1];

        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) {
            // Check if minChar appears anywhere else
            boolean minElsewhere = false;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == minChar) {
                    minElsewhere = true;
                    break;
                }
            }
            // Check if maxChar appears anywhere else
            boolean maxElsewhere = false;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == maxChar) {
                    maxElsewhere = true;
                    break;
                }
            }

            if (!minElsewhere && !maxElsewhere) {
                return 3;
            }
        }

        return 2;
    }
}