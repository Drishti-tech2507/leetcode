class Solution {
    public long[] resultArray(int[] nums, int k) {
         long[] ans = new long[k];

        

        long[] prev = new long[k];

        

        for (int num : nums) {

            long[] curr = new long[k];

            

            int rem = num % k;

            

            // Subarray containing only current element

            curr[rem]++;

            

            // Extend previous subarrays

            for (int j = 0; j < k; j++) {

                if (prev[j] > 0) {

                    int newRem = (j * rem) % k;

                    curr[newRem] += prev[j];

                }

            }

            for (int j = 0; j < k; j++) {

                ans[j] += curr[j];

            }
            prev = curr;

        }
        return ans;
    }
}