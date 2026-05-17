package Timus;

import java.util.Scanner;

public class Task1409 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int harry = scanner.nextInt();
        int larry = scanner.nextInt();

        int total = harry + larry - 1;
        int harryMissed = total - harry;
        int larryMissed = total - larry;

        System.out.println(harryMissed + " " + larryMissed);
    }
}