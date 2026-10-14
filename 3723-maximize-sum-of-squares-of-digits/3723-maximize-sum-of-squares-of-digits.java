class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Check if a valid num-digit number is possible
        if (sum < 1 || (long) sum > 9L * num) {
            return "";
        }

        int fullNines = sum / 9;
        int rem = sum % 9;
        int zeros = num - fullNines - (rem > 0 ? 1 : 0);

        StringBuilder sb = new StringBuilder(num);

        // Append '9's
        for (int i = 0; i < fullNines; i++) {
            sb.append('9');
        }

        // Append the remaining single digit if sum is not a multiple of 9
        if (rem > 0) {
            sb.append(rem);
        }

        // Pad with '0's to make the length equal to num
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}