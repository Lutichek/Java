package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int targetNumber;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число для поиска в матрице: ");
            try {
                targetNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                return;
            }
        }

        boolean found = false;
        System.out.println("Столбец с числом " + targetNumber + ":");
        for (int[] value : matrix) {
            for (int j = 0; j < value.length; j++) {
                if (value[j] == targetNumber) {
                    found = true;
                    for (int[] ints : matrix) {
                        System.out.println(ints[j]);
                    }
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Ошибка: число " + targetNumber + " не найдено в матрице.");
        }
    }
}