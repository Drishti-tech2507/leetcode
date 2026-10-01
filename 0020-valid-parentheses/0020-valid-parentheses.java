class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push corresponding closing brackets for open brackets
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                // If stack is empty or top doesn't match, it's invalid
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }
}