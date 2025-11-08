class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();  // stores number and its last index

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (Math.abs(i - prevIndex) <= k) {
                    return true;   // found two indices with same value within distance k
                }
            }
            map.put(nums[i], i);  // update the latest index
        }

        return false;
    }
}