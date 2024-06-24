import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment8 {


    private static int factorial(int n) {
        int i = n == 0 || n == 1 ? 1 : n * factorial(n - 1);
        return i;
    }


    public static String getNthPermutation(int L, int N) {

        List<Character> characters = new ArrayList<>();
        for (char c = 'a'; c < 'a' + L; c++) {
            characters.add(c);
        }

        N -= 1;
        StringBuilder result = new StringBuilder();

        for (int i = L; i > 0; i--) {
            int factorial = factorial(i - 1);
            int index = N / factorial;
            result.append(characters.get(index));
            characters.remove(index);
            N %= factorial;
        }

        return result.toString();
    }

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int L = s.nextInt();
       int N = s.nextInt();
       String nthPermutation = getNthPermutation(L, N);
       System.out.println(nthPermutation);
       s.close();

    }
}
