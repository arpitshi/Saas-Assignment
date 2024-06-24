import java.util.Scanner;

public class Assignment4 {

    public static int ackerman(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ackerman(m - 1, 1);
        } else {
            return ackerman(m - 1, ackerman(m, n - 1));
        }
    }
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();

        int result = ackerman(m, n);
        System.out.println("A(" + m + ", " + m + ") = " + result);
    }
}
