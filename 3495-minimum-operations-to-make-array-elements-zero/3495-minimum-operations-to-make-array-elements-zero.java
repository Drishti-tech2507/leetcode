class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        
        for (int[] query : queries) {
            long left = query[0];
            long right = query[1];
            long prev = 1;
            long ops = 0;

            for (long pow = 1; pow <= 16; pow++) {
                long curr = prev * 4;

                long leftrange = Math.max(left, prev);
                long rightrange = Math.min(right, curr - 1);

                if (rightrange >= leftrange) {
                    ops += (rightrange - leftrange + 1) * pow;
                }

                prev = curr;
            }
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}