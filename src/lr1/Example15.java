package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input first number: ");
        int number1 = in.nextInt();
        System.out.println("Input second number: ");
        int number2 = in.nextInt();
        int sum = number1 + number2;
        int diff = number1 - number2;
        System.out.printf("Sum of %d and %d equals %d ", number1, number2, sum);
        System.out.printf("\nDifference of %d and %d equals %d ", number1, number2, diff);
        in.close();
    }
}