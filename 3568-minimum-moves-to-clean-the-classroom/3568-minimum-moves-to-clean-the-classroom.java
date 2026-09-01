class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;

        int m = classroom[0].length();

        int sr = 0, sc = 0;

        List<int[]> litter = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {

                    sr = i;

                    sc = j;

                } else if (ch == 'L') {

                    litter.add(new int[]{i, j});

                }

            }

        }

        int k = litter.size();

        if (k == 0) return 0;

        // If there are too many pieces of litter for a bitmask

        if (k > 20) return -1;

        int fullMask = (1 << k) - 1;

        // State: row, col, energy, cleaned-litter-mask

        int[][][][] dist = new int[n][m][energy + 1][1 << k];

        for (int[][][] a : dist)

            for (int[][] a2 : a)

                for (int[] a3 : a2)

                    Arrays.fill(a3, -1);

        Queue<int[]> q = new LinkedList<>();

        dist[sr][sc][energy][0] = 0;

        q.offer(new int[]{sr, sc, energy, 0});

        int[] dr = {-1, 1, 0, 0};

        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];

            int c = cur[1];

            int e = cur[2];

            int mask = cur[3];

            int moves = dist[r][c][e][mask];

            if (mask == fullMask)

                return moves;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (classroom[nr].charAt(nc) == 'X')

                    continue;

                if (e == 0)
                    continue;
                int ne = e - 1;
                int newMask = mask;
                for (int i = 0; i < k; i++) {

                    if (litter.get(i)[0] == nr &&
                        litter.get(i)[1] == nc) {
                        newMask |= (1 << i);
                        break;

                    }
                }
                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }
                if (dist[nr][nc][ne][newMask] == -1) {
                    dist[nr][nc][ne][newMask] = moves + 1;
                    q.offer(new int[]{nr, nc, ne, newMask});

                }
            }
        }

        return -1;
    }
}