class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> ans = new ArrayList<>();
       int n = matrix .length;
       int m = matrix[0].length;
       int t = 0, left = 0;
       int b = n - 1, right = m -1;
       while(t <= b && left <= right)
       {
        for(int i = left; i <= right; ++i)
        {
            ans.add(matrix[t][i]);
        }
        t++;
        for(int i = t; i <= b; ++i)
        {
            ans.add(matrix[i][right]);
        }
        right--;
        if(t <= b)
        {
            for(int i = right; i >= left; --i)
            {
                ans.add(matrix[b][i]);
            }
            b--;
        }
        if(left <= right)
        {
            for(int i = b; i >= t; --i)
            {
                ans.add(matrix[i][left]);
            }
            left++;
        }
       }
       return ans;
    }
}