import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int sr = 0;
        int sc = 0;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc, energy, 0});

        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                if (mask == totalMasks - 1) {
                    return moves;
                }

                if (currentEnergy == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = currentEnergy - 1;

                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {
                        visited[nr][nc][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}