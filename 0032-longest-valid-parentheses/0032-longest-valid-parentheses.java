class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(-1);  // base index

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // reset base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}