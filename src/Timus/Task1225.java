package Timus;

import java.util.Scanner;

public class Task1225 { public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int[] queries = new int[parts.length];
        int maxN = 0;

        for (int i = 0; i < parts.length; i++) {
            queries[i] = Integer.parseInt(parts[i]);
            maxN = Math.max(maxN, queries[i]);
        }

        long[] dp = new long[Math.max(4, maxN + 1)];

        dp[1] = 2;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int i = 0; i < queries.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(dp[queries[i]]);
        }
    }
}
