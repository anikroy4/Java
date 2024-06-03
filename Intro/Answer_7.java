package Java.Intro;

import java.util.Scanner;
public class Answer_7 {
    public static void main(String[] args) {
        Scanner integer = new Scanner(System.in);
        System.out.println("Enter an integer Value: ");
        int a = integer.nextInt();

        Scanner floating = new Scanner(System.in);
        System.out.println("Enter a floating Point Value: ");
        float b = floating.nextFloat();

        Scanner character = new Scanner(System.in);
        System.out.println("Enter a Character Value: ");
        char c = character.next().charAt(0);


        System.out.println("The Integer Value is: " + a);
        System.out.println("The Floating Point Value is: " + b);
        System.out.println("The Character Value is: " + c);
    }
}
