package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input day of week: ");
        String day = in.nextLine();
        System.out.println("Input month: ");
        String month = in.nextLine();
        System.out.println("Input day of month: ");
        int day_in_month = in.nextInt();
        System.out.println("today: " + day + ", " + day_in_month + ", " + month);
        in.close();
    }
}
