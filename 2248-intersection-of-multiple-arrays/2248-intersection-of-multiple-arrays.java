class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums[0]);
        List<Integer>result = new ArrayList<>();
        for(int num:nums[0])
        {
            result.add(num);
        }
         for (int i = 1; i < n; i++) {
            Arrays.sort(nums[i]);
            result = findCommon(result, nums[i]);
        }
        return result;
    }
     private static List<Integer> findCommon(List<Integer> list, int[] arr) {
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list.size() && j < arr.length) {
            if (list.get(i).equals(arr[j])) {
                temp.add(arr[j]);
                i++;
                j++;
            } else if (list.get(i) < arr[j]) {
                i++;
            } else {
                j++;
            }
        }

        return temp;
     }
}