class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new TreeSet <>();
        for(int val : nums)
        {
            s.add(val);
        }
        int k = s.size();
        int j = 0;
        for(int val : s)
        {
            nums[j++] = val;
        }
        return k;
    }
}