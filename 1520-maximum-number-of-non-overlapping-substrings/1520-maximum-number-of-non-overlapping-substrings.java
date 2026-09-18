class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        // Store first and last occurrence of each character

        int[] first = new int[26];

        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {

                first[c] = i;

            }

            last[c] = i;

        }

        List<int[]> intervals = new ArrayList<>();

        // Try to create a valid interval for every character

        for (int c = 0; c < 26; c++) {

            if (first[c] == -1)

                continue;

            int start = first[c];

            int end = last[c];

            boolean valid = true;

            for (int i = start; i <= end; i++) {

                int current = s.charAt(i) - 'a';

                // This character occurs before start,

                // so substring cannot be valid

                if (first[current] < start) {

                    valid = false;

                    break;

                }

                // Expand interval if this character

                // occurs after current end

                end = Math.max(end, last[current]);

            }

            if (valid) {

                intervals.add(new int[]{start, end});

            }

        }

        // Sort intervals by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        // Greedily select non-overlapping intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }
        return result;
    }
}