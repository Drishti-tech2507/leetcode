class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> ans = new ArrayList<>();

        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, ans);

        return ans;

    }

    private void backtrack(String s, int index, List<String> path,

                           List<List<String>> ans) {

        // Base case: Entire string is partitioned

        if (index == s.length()) {

            ans.add(new ArrayList<>(path));

            return;

        }

        // Try every possible substring

        for (int i = index; i < s.length(); i++) {

            String sub = s.substring(index, i + 1);

            if (isPalindrome(sub)) {

                path.add(sub);

                backtrack(s, i + 1, path, ans);

                // Backtracking

                path.remove(path.size() - 1);

            }

        }

    }

    private boolean isPalindrome(String str) {

        int left = 0;

        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {

                return false;

            }

            left++;

            right--;

        }

        return true;
    }
}