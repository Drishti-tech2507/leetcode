class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        // Sort by x ascending; if x equal, by y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int yAlice = points[i][1];
            int maxYSeen = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int yBob = points[j][1];
                if (yBob <= yAlice && yBob > maxYSeen) {
                    ans++;
                    maxYSeen = yBob;
                }
            }
        }
        return ans;
    }
}