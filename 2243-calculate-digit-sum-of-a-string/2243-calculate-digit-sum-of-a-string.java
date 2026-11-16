class Solution {
    public String digitSum(String s, int k) {

        // Repeat until the string length is less than or equal to k
        while (s.length() > k) {

            StringBuilder result = new StringBuilder();

            // Divide the string into groups of size k
            for (int i = 0; i < s.length(); i += k) {

                int sum = 0;

                // Calculate sum of digits in the current group
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }

                // Append the digit sum to the result
                result.append(sum);
            }

            // Update the original string
            s = result.toString();
        }

        // Return the final string
        return s;
    }
}