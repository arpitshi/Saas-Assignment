import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment12 {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static int mazePath(int R, int C, char[][] grid) {
        int srow = -1, scol = -1;
        int erow = -1, ecol = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '#') {
                    srow = i;
                    scol = j;
                } else if (grid[i][j] == '@') {
                    erow = i;
                    ecol = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];

        q.offer(new int[]{srow, scol, 0});
        vis[srow][scol] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];

            if (r == erow && c == ecol) {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !vis[nr][nc] && (grid[nr][nc] == '1' || grid[nr][nc] == '@')) {
                    q.offer(new int[]{nr, nc, cnt + 1});
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int R = s.nextInt();
        int C = s.nextInt();
        s.nextLine();

        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = s.nextLine().replaceAll(" ", "");
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int result = mazePath(R, C, grid);
        System.out.println(result);

        s.close();
    }
}
