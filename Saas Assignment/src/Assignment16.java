import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Assignment16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String mstr = s.nextLine();
        String pstr = s.nextLine();

        s.close();

        Pattern p = Pattern.compile(pstr);
        Matcher m = p.matcher(mstr);

        int maxml=0;
        int matchend = 0;

        while (m.find()) {
            int ml = m.end() - m.start();
            if (ml > maxml) {
                maxml = ml;
                matchend = m.end();
            }
        }
        System.out.println(maxml);

    }
}
