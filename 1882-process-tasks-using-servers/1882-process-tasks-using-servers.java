class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
         int n = servers.length;

        int m = tasks.length;

        int[] ans = new int[m];

        // Free servers: [weight, index]

        PriorityQueue<int[]> free = new PriorityQueue<>(

            (a, b) -> {

                if (a[0] != b[0])

                    return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);

            }

        );

        // Busy servers: [freeTime, weight, index]

        PriorityQueue<long[]> busy = new PriorityQueue<>(

            (a, b) -> {

                if (a[0] != b[0])

                    return Long.compare(a[0], b[0]);

                if (a[1] != b[1])

                    return Long.compare(a[1], b[1]);

                return Long.compare(a[2], b[2]);

            }

        );

        // Initially all servers are free

        for (int i = 0; i < n; i++) {

            free.offer(new int[]{servers[i], i});

        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            // Time cannot go backwards

            time = Math.max(time, i);

            // Release all servers available at current time

            while (!busy.isEmpty() && busy.peek()[0] <= time) {

                long[] s = busy.poll();

                free.offer(new int[]{

                    (int) s[1],

                    (int) s[2]

                });

            }

            // If no server is free, move time forward

            if (free.isEmpty()) {

                time = busy.peek()[0];

                // Release every server that becomes free now

                while (!busy.isEmpty() && busy.peek()[0] <= time) {

                    long[] s = busy.poll();

                    free.offer(new int[]{

                        (int) s[1],

                        (int) s[2]

                    });

                }

            }

            // Select the best available server

            int[] server = free.poll();

            int weight = server[0];

            int index = server[1];

            ans[i] = index;

            // Assign task and calculate completion time

            busy.offer(new long[]{

                time + tasks[i],

                weight,

                index

            });

        }

        return ans;
    }
}