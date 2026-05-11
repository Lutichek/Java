package Timus;

import java.util.Scanner;

public class Task1327 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int count = (B + 1) / 2 - A / 2;

        System.out.println(count);
    }
}