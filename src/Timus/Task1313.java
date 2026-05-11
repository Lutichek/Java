package Timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1313 {
    public static void main(String[] args) {
        String inputFileName = "Timus/input1313.txt";
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            BufferedReader bufferedReader = oj ? new BufferedReader(new InputStreamReader(System.in)) :
                    new BufferedReader(new FileReader(inputFileName));

            int size = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[size][size];

            // Чтение матрицы из файла
            for (int i = 0; i < size; i++) {
                String[] values = bufferedReader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            // Вывод диагоналей
            printDiagonals(matrix, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDiagonals(int[][] matrix, int size) {
        // Вывод главной диагонали и ее выше
        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(matrix[j][i - j] + " ");
            }
        }

        // Вывод диагоналей под главной
        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= i; j--) {
                System.out.print(matrix[j][size - j + i - 1] + " ");
            }
        }
    }
}
