import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        boolean[] nozeroRow = new boolean[R];
        boolean[] nozeroCol = new boolean[C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] != 0) {
                    nozeroRow[i] = true;
                    nozeroCol[j] = true;

                }
            }
        }
        List<Integer> rowtokeep = new ArrayList<>();
        List<Integer> coltokeep = new ArrayList<>();

        for(int i = 0;i<R;i++){
            if(nozeroRow[i]){
                rowtokeep.add(i);
            }
        }
        for(int i = 0;i<C;i++){
            if(nozeroCol[i]){
                coltokeep.add(i);
            }
        }

        for (int i : rowtokeep) {
            for (int j : coltokeep) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
