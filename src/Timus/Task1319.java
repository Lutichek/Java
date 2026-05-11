package Timus;

import java.util.Scanner;

public class Task1319 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] table = createTable(size);

        for (int[] row : table) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j != row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] createTable(int size) {
        int[][] result = new int[size][size];
        int number = 0;
        int si = 0;
        int sj = size - 1;

        do {
            for (int i = 0; si + i < size && sj + i < size; i++) {
                result[si + i][sj + i] = ++number;
            }
            if (sj > 0) {
                sj--;
            } else {
                si++;
            }
        } while (si < size);

        return result;
    }
}
