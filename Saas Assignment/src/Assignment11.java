import java.util.*;

public class Assignment11 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = s.nextInt();
            int value = s.nextInt();
            map.put(key, value);
        }

        int m = s.nextInt();
        int[] moves = new int[m];

        // Read the moves
        for (int i = 0; i < m; i++) {
            moves[i] = s.nextInt();
        }

        s.close();

        int a = 0;
        int b = 0;
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                a += moves[i];
                while (map.containsKey(a)) {
                    a = map.get(a);
                }
            } else {
                b += moves[i];
                while (map.containsKey(b)) {
                    b = map.get(b);
                }
            }
        }

        // Determine the result
        if (Math.max(a, b) == a) {
            System.out.println("A " + a);
        } else {
            System.out.println("B " + b);
        }
    }
}
