import java.util.Scanner;

public class Assigement2 {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int wordcnt = 0;

       while (s.hasNextLine()) {
           String line = s.nextLine();
           String[] words = line.split("\\s+");

           for (String word : words) {
               if (!word.isEmpty()) {
                   wordcnt++;
               }
           }
           System.out.println(wordcnt);
       }
    }
}
