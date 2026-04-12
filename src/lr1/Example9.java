package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the name of the current month: ");
        String month = in.nextLine();
        System.out.println("Input Number of days in the current month: ");
        int number_of_days = in.nextInt();
        System.out.printf("%s contains %d days", month, number_of_days);
        in.close();
    }
}
