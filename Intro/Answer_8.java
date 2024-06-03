package Java.Intro;

import java.util.Scanner;

public class Answer_8 {
    public static void main(String[] args) {
        Scanner First = new Scanner(System.in);
        System.out.println("Enter an First Value: ");
        int FirstValue = First.nextInt();

        Scanner Second = new Scanner(System.in);
        System.out.println("Enter an Second Value: ");
        int SecondValue = Second.nextInt();

        Scanner Third = new Scanner(System.in);
        System.out.println("Enter an Last Value: ");
        int ThirdValue = Third.nextInt();

        System.out.println("The first value is: " + FirstValue);
        System.out.println("The last value is: " + ThirdValue);
    }
}
