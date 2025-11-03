class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0; // safe default because majority is guaranteed to exist
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        // Create an object to call the non-static method
        Solution obj = new Solution();

        System.out.println("Majority Element in nums1: " + obj.majorityElement(nums1)); // 3
        System.out.println("Majority Element in nums2: " + obj.majorityElement(nums2)); // 2
    }
}