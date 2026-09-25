import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length() - 1);
        return new ArrayList<>(new TreeSet<>(result));
    }

    // Parse an expression between l and r
    private Set<String> parse(String s, int l, int r) {
        Set<String> result = new HashSet<>();

        int i = l;

        while (i <= r) {
            Set<String> current;

            if (s.charAt(i) == '{') {
                int j = findClosingBrace(s, i);

                current = parseInside(s, i + 1, j - 1);
                i = j + 1;
            } else {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(i)));
                i++;
            }

            // Concatenate with previous part
            if (result.isEmpty()) {
                result.addAll(current);
            } else {
                result = concatenate(result, current);
            }
        }

        return result;
    }

    // Handles expressions inside { }
    private Set<String> parseInside(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        int start = l;
        int level = 0;

        for (int i = l; i <= r; i++) {

            if (s.charAt(i) == '{') {
                level++;
            } else if (s.charAt(i) == '}') {
                level--;
            } else if (s.charAt(i) == ',' && level == 0) {

                result.addAll(parse(s, start, i - 1));
                start = i + 1;
            }
        }

        // Last expression
        result.addAll(parse(s, start, r));

        return result;
    }

    // Cartesian product + concatenation
    private Set<String> concatenate(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }

    // Find matching }
    private int findClosingBrace(String s, int start) {
        int level = 0;

        for (int i = start; i < s.length(); i++) {

            if (s.charAt(i) == '{') {
                level++;
            } else if (s.charAt(i) == '}') {
                level--;

                if (level == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}