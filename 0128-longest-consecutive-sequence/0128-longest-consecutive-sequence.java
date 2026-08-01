class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }
        int l = 0;
        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int currN  = num;
                int currL = 1;
                while (set.contains(currN + 1))
                {
                    currN++;
                    currL++;
                }
                l = Math.max(l, currL);
            }
        }
        return l;
    }
}