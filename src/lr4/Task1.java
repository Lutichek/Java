package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите положительное целое число - длину массива: ");
            int length;
            try {
                length = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                return;
            }
            if (length <= 0) {
                System.out.println("Ошибка: неверный размер массива.");
                return;
            }

            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                System.out.print("Введите элемент массива #" + (i + 1) + ": ");
                try {
                    int num = scanner.nextInt();
                    array[i] = num;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                    return;
                }
            }

            boolean hasPositive = false;
            int sum = 0;
            for (int num : array) {
                if (num > 0) {
                    hasPositive = true;
                    sum += num;
                }
            }

            if (!hasPositive) {
                System.out.println("Ошибка: в массиве нет положительных элементов.");
                return;
            }

            double average = (double) sum / length;
            System.out.println("Среднее значение среди положительных элементов: " + average);
        }
    }
}