class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new ArrayDeque<>();
        long cost = 0;
        long a = 0;
        int j = n - 1;
        for (int i = n - 1; i >= 0; i--)
        {
           int num = nums[i];
           int c = 1;
           while (!dq.isEmpty() && dq.peekLast()[0] < num)
           {
            int[] last = dq.pollLast();
            int nextN = last[0];
            int nextC = last[1];
            c += nextC;
            cost += (long) (num - nextN) * nextC;
           }
           dq.offerLast(new int[]{num, c});
           while (cost > k) {
            int[] first = dq.pollFirst();
            int rightN = first[0];
            int rightC = first[1];
            cost -= rightN - nums[j];
            j--;
            if (rightC > 1) {
                    dq.offerFirst(
                        new int[]{rightN, rightC - 1}

                    );
                }
            }
            a += j - i + 1;
        }
        return a;
    }
}