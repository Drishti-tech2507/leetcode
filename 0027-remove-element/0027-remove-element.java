class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the position of the next non-val element
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the non-val element to the front
                k++; // Increment the count of non-val elements
            }
        }
        return k; // Return the count of non-val elements
    }

    }

