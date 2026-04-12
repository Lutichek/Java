package Timus;

import java.util.Scanner;

public class Task1224 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long M = in.nextLong();
        System.out.println((Math.min(N - 1L, M - 1L) << 1) + (N > M ? 1 : 0));
    }
}