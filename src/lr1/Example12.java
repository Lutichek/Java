package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int current_year = Year.now().getValue();
        System.out.println("Input your age: ");
        int age = in.nextInt();
        int year1 = current_year - age;
        int year2 = year1 - 1;
        System.out.printf("Your age: %d-%d", year1, year2);
        in.close();
    }
}
