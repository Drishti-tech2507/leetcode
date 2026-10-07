import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        Set<String> result = new HashSet<>();

        // Find minimum number of removals
        int leftRemove = 0;
        int rightRemove = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;

            } else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        // DFS
        dfs(s, 0, leftRemove, rightRemove,
            0, new StringBuilder(), result);

        return new ArrayList<>(result);
    }


    private void dfs(String s,
                     int index,
                     int leftRemove,
                     int rightRemove,
                     int balance,
                     StringBuilder current,
                     Set<String> result) {

        // Invalid parentheses
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(current.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // -------------------------
        // CASE 1: '('
        // -------------------------
        if (c == '(') {

            // Remove '('
            if (leftRemove > 0) {

                dfs(s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    current,
                    result);
            }

            // Keep '('
            current.append('(');

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current,
                result);

            current.deleteCharAt(current.length() - 1);
        }

        // -------------------------
        // CASE 2: ')'
        // -------------------------
        else if (c == ')') {

            // Remove ')'
            if (rightRemove > 0) {

                dfs(s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    current,
                    result);
            }

            // Keep ')' only if '(' exists
            if (balance > 0) {

                current.append(')');

                dfs(s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current,
                    result);

                current.deleteCharAt(current.length() - 1);
            }
        }

        // -------------------------
        // CASE 3: Letter
        // -------------------------
        else {

            current.append(c);

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current,
                result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}