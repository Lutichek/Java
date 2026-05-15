package lr3.Task2;

import java.util.Scanner;

public class Main {
    public static void decimalToBinary(int n) {
        if (n > 1) {
            decimalToBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int decimal = in.nextInt();
        System.out.println("Двоичное представление числа " + decimal + ": ");
        decimalToBinary(decimal);
        in.close();
    }
}