package lr3.Task3;

import java.util.Scanner;

public class Main {
    public static void inputArray(int[] arr, int index, Scanner in) {
        if (index < arr.length) {
            System.out.print("Введите элемент массива [" + index + "] = ");
            arr[index] = in.nextInt();
            inputArray(arr, index + 1, in);
        }
    }

    public static void outputArray(int[] arr, int index) {
        if (index < arr.length) {
            System.out.println("Элемент массива [" + index + "] = " + arr[index]);
            outputArray(arr, index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        int[] array = new int[size];
        inputArray(array, 0, in);
        System.out.println("Вывод массива: ");
        outputArray(array, 0);
        in.close();
    }
}