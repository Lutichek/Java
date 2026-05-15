package Timus;

import java.util.Scanner;

public class Task1370 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] digits = new int[N];
        for (int i = 0; i < N; i++) {
            digits[i] = scanner.nextInt();
        }

        int start = M % N;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (start + i) % N;
            result.append(digits[index]);
        }

        System.out.println(result.toString());
    }
}