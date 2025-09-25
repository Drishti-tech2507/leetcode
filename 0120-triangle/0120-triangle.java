class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int row = triangle.size()-2; row >= 0; row--)
        {
            for(int col = 0; col < triangle.get(row).size(); col++)
            {
                int below = triangle.get(row + 1).get(col);
                int belowRight = triangle.get(row+1).get(col+1);
                int updatedValue = triangle.get(row).get(col)+Math.min(below, belowRight);
                triangle.get(row).set(col, updatedValue);
            }
        }
        return triangle.get(0).get(0);
    }
}