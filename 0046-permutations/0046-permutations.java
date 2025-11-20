class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result,List<Integer> temp, boolean[] used)
    {
        if(temp.size() == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, result, temp, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}