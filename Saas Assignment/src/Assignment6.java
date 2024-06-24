import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment6 {

    private static final Map<Character, Integer> romantoint = new LinkedHashMap<>();
    private static final Map<Integer, String> inttoroman = new LinkedHashMap<>();

    static {
        romantoint.put('I', 1);
        romantoint.put('V', 5);
        romantoint.put('X', 10);
        romantoint.put('L', 50);
        romantoint.put('C', 100);
        romantoint.put('D', 500);
        romantoint.put('M', 1000);

        inttoroman.put(1000, "M");
        inttoroman.put(900, "CM");
        inttoroman.put(500, "D");
        inttoroman.put(400, "CD");
        inttoroman.put(100, "C");
        inttoroman.put(90, "XC");
        inttoroman.put(50, "L");
        inttoroman.put(40, "XL");
        inttoroman.put(10, "X");
        inttoroman.put(9, "IX");
        inttoroman.put(5, "V");
        inttoroman.put(4, "IV");
        inttoroman.put(1, "I");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = s.nextLine();
            if (input.matches("\\d+")) {
                int inputInt = Integer.parseInt(input);
                System.out.println(intToRoman(inputInt));
            } else {
                System.out.println(romanToInt(input));
            }
        }
        s.close();
    }

    public static int romanToInt(String s) {
        int res = 0;
        int prvVal = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (!romantoint.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + s);
            }
            int currentValue = romantoint.get(currentChar);

            if (currentValue < prvVal) {
                res -= currentValue;
            } else {
                res += currentValue;
            }
            prvVal = currentValue;
        }
        return res;
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : inttoroman.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
        }

        return sb.toString();
    }
}



//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Assignment6 {
//
//    private static final Map<Integer, String> romanMap = new LinkedHashMap<>();
//
//    static {
//        romanMap.put(1000, "M");
//        romanMap.put(900, "CM");
//        romanMap.put(500, "D");
//        romanMap.put(400, "CD");
//        romanMap.put(100, "C");
//        romanMap.put(90, "XC");
//        romanMap.put(50, "L");
//        romanMap.put(40, "XL");
//        romanMap.put(10, "X");
//        romanMap.put(9, "IX");
//        romanMap.put(5, "V");
//        romanMap.put(4, "IV");
//        romanMap.put(1, "I");
//    }
//
//    public static String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//
//        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
//            while (num >= entry.getKey()) {
//                sb.append(entry.getValue());
//                num -= entry.getKey();
//            }
//        }
//
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter an integer: ");
//        int num = scanner.nextInt();
//        String roman = intToRoman(num);
//        System.out.println("The Roman numeral for " + num + " is: " + roman);
//    }
//
//}
