package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your number: ");
        int number = in.nextInt();
        System.out.printf("Order: %d; %d; %d; %f", number - 1, number, number + 1, Math.pow((double)(number * 3), 2));
        in.close();
    }
}