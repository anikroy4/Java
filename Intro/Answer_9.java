package Java.Intro;
import java.util.Scanner;

public class Answer_9 {
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        System.out.println("Enter an value: ");
        double a = value.nextDouble();
        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println("the double value is: " + a);

        System.out.println("The boolean value (true): " + isTrue);
        System.out.println("The boolean value (false): " + isFalse);
    }
}
