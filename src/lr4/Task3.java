package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int length;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива: ");
            try {
                length = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                return;
            }

            byte[] array = new byte[length];
            int sum = 0;
            for (int i = 0; i < length; i++) {
                System.out.print("Введите элемент массива #" + (i + 1) + ": ");
                try {
                    byte num = scanner.nextByte();
                    sum += num;
                    if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                        System.out.println("Ошибка: сумма элементов выходит за пределы диапазона типа byte.");
                        return;
                    }
                    array[i] = num;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено число, недопустимое для типа byte (от -128 до 127).");
                    return;
                }
            }

            System.out.println("Сумма элементов массива: " + sum);
        }
    }
}