import java.util.Scanner;

public class Assignment1 {

    public static String determinetriangele(double num1, double num2, double num3) {
        if(!validtriangle(num1, num2, num3)) {
            return "Invalid Triangle";
        }
        if (isEquilateral(num1, num2, num3)) {
            return "Equilateral Triangle";
        }
        if (isoceles(num1, num2, num3)) {
            return "Isosceles Triangle";
        }
        if (rightangled(num1, num2, num3)) {
            return "Right-Angled Triangle";
        } else {
            return "Notspecial Triangle";
        }
    }

    public static boolean validtriangle(double num1, double num2, double num3) {
        if (num1 + num2 > num3 && num1 + num3 > num2 && num2 + num3 > num1) {
            return true;
        } else
            return false;

    }
    public static boolean isEquilateral(double num1, double num2, double num3) {
            return num1 == num2 && num2 == num3;

    }
    public static boolean isoceles(double num1, double num2, double num3) {
        return num1 == num2 || num2 == num3 || num1 == num3;
    }
    public static boolean rightangled(double num1, double num2, double num3) {
        double square1 = Math.pow(num1, 2);
        double square2 = Math.pow(num2, 2);
        double square3 = Math.pow(num3, 2);

        return square1 + square2 == square3 || square1 + square3 == square2 || square2 + square3 == square1;
    }
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);

       double num1 = s.nextDouble();
       double num2 = s.nextDouble();
       double num3 = s.nextDouble();

       String result = determinetriangele(num1, num2, num3);
       System.out.println(result);

       s.close();
    }


}
