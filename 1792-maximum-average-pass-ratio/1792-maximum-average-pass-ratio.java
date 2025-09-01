class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(marginalGain(b[0], b[1]), marginalGain(a[0], a[1]))
        );

        // Initialize heap
        for (int[] c : classes) {
            pq.offer(new int[] { c[0], c[1] }); // {passed, total}
        }

        // Distribute extra students greedily
        for (int i = 0; i < extraStudents; i++) {
            int[] top = pq.poll();
            top[0]++; // increment passed
            top[1]++; // increment total
            pq.offer(top);
        }

        // Compute final average pass ratio
        double sum = 0.0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double) c[0] / c[1];
        }

        return sum / classes.length;
    }

    private static double marginalGain(int p, int t) {
        // (p+1)/(t+1) - p/t
        return (double) (p + 1) / (t + 1) - (double) p / t;
    }
    }