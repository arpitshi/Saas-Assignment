import java.util.Scanner;

public class Assignment10 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int V = s.nextInt();
        int H = s.nextInt();

        int[][] vertseg = new int[V][3];
        for (int i = 0; i < V; i++) {
            vertseg[i][0] = s.nextInt();
            vertseg[i][1] = s.nextInt();
            vertseg[i][2] = s.nextInt();
        }

        int[][] horiseg = new int[H][3];
        for (int i = 0; i < H; i++) {
            horiseg[i][0] = s.nextInt();
            horiseg[i][1] = s.nextInt();
            horiseg[i][2] = s.nextInt();
        }

        int Count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < H; j++) {
                if (intersects(vertseg[i], horiseg[j])) {
                    Count++;
                }
            }
        }

        System.out.println(Count);
        s.close();
    }

    private static boolean intersects(int[] vertical, int[] horizontal) {
        int x = vertical[0];
        int y1 = Math.min(vertical[1], vertical[2]);
        int y2 = Math.max(vertical[1], vertical[2]);

        int y = horizontal[0];
        int x1 = Math.min(horizontal[1], horizontal[2]);
        int x2 = Math.max(horizontal[1], horizontal[2]);


        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}