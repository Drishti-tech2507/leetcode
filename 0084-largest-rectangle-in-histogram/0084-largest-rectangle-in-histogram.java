class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        for(int i = 0; i <= n; i++)
        {
            int currentH = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentH < heights[stack.peek()])
            {
                int h = heights[stack.pop()];
                int w;
                if(stack.isEmpty())
                {
                    w = i;
                }
                else
                {
                    w = i - stack.peek() - 1;
                }
                maxA = Math.max(maxA, h * w);
            }
            stack.push(i);
        }
        return maxA;
    }
}