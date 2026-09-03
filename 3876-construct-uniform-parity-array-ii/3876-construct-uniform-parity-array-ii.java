class Solution {
    public boolean uniformArray(int[] nums1) {
         int minOdd = Integer.MAX_VALUE;

        boolean hasOdd = false;

        boolean hasEven = false;

        // Find the smallest odd number

        for (int num : nums1) {

            if (num % 2 == 0) {

                hasEven = true;

            } else {

                hasOdd = true;

                minOdd = Math.min(minOdd, num);

            }

        }

        if (!hasOdd) {

            return true;

        }

        for (int num : nums1) {
            if (num % 2 == 0 && num <= minOdd) {
                return false;
            }

        }
        return true;
    }
}