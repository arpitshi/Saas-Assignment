import java.util.*;

public class Assignment5 {


        private static final char alive = '@';
        private static final char dead = '#';



        private static int cntneighbors(char[][] grid, int row, int col) {
            int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};
            int cnt = 0;


            for (int i = 0; i < 8; i++) {
                int nr = row + r[i];
                int nc = col + c[i];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == alive) {
                    cnt++;
                }
            }

            return cnt;

        }

    private static char[][] nextGeneration(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] newGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = cntneighbors(grid, i, j);

                if (grid[i][j] == alive) {
                    if (neighbors < 2 || neighbors > 3) {
                        newGrid[i][j] = dead;
                    } else {
                        newGrid[i][j] = alive;
                    }
                } else {
                    if (neighbors == 3) {
                        newGrid[i][j] = alive;
                    } else {
                        newGrid[i][j] = dead;
                    }
                }
            }
        }
        return newGrid;

    }
    private static int cntliveCells(char[][] grid) {
        int cnt = 0;
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == alive) {
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();
        s.nextLine();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = s.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int gen = s.nextInt();

        for (int i = 0; i < gen; i++) {
            grid = nextGeneration(grid);
        }
       int liveCells = cntliveCells(grid);
        System.out.println(liveCells);
        s.close();
    }
}
