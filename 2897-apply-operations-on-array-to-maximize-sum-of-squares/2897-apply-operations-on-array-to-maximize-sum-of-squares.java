class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] count = new int[31];
        
        // Count set bits at each bit position across all numbers
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        
        long totalSum = 0;
        
        // Construct the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (count[bit] > 0) {
                    currentNum |= (1L << bit);
                    count[bit]--;
                }
            }
            // Add currentNum^2 % MOD to totalSum
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}