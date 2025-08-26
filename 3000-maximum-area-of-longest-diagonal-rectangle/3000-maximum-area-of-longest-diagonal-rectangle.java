class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int maxArea = 0;
        for(int i = 0; i < dimensions.length; i++)
        {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int diag = l*l + w*w;
            int a = l*w;
            if(diag > maxDiag)
            {
                maxDiag = diag;
                maxArea = a;
            }
            else if(diag == maxDiag)
            {
                maxArea = Math.max(maxArea, a);
            }
        }
        return maxArea;
    }
};