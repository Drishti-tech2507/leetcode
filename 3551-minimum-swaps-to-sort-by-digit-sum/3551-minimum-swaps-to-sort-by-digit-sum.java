class Solution {
    public int minSwaps(int[] nums) {
         int n = nums.length;

        // Create a copy of the original array

        int[] sorted = nums.clone();

        // Sort by digit sum, then by numerical value

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {

            arr[i] = nums[i];

        }

        Arrays.sort(arr, (a, b) -> {

            int sumA = digitSum(a);

            int sumB = digitSum(b);

            if (sumA != sumB) {

                return Integer.compare(sumA, sumB);

            }

            return Integer.compare(a, b);

        });

        // Map each number to its current index

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            indexMap.put(nums[i], i);

        }

        int swaps = 0;

        // Place every element at its correct position

        for (int i = 0; i < n; i++) {

            if (nums[i] != arr[i]) {

                int correctIndex = indexMap.get(arr[i]);

                // Update the index map

                indexMap.put(nums[i], correctIndex);

                indexMap.put(arr[i], i);

                // Swap elements

                int temp = nums[i];

                nums[i] = nums[correctIndex];

                nums[correctIndex] = temp;

                swaps++;

            }

        }

        return swaps;

    }

    // Calculate the sum of digits

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {

            sum += num % 10;

            num /= 10;

        }

        return sum;
    }
}