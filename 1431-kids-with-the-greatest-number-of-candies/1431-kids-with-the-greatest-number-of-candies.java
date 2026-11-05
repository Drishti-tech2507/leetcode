class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int c = 0;
        for (int i = 0; i < candies.length; i++)
        {
            c = Math.max(c, candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++)
        {
            if(candies[i] + extraCandies >= c)
            {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}