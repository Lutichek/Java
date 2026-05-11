package lr2;

import java.util.Scanner;
import java.util.Random;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Размер массива: ");
        int size = in.nextInt();
        System.out.println("Размер массива равен: " + size);
        int[] nums = new int[size];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println("Элементы массива:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Индекс " + i + ": " + nums[i]);
        }
        System.out.println("Начинается поиск минимума");
        int min = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("Поиск минимума закончен.\nЗначение минимума = " + min);
        System.out.println("Поиск всех минимальных");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                System.out.println("Индекс минимального элемента: " + i);
                System.out.println("Значение минимального элемента: " + nums[i]);
            }
        }
    }
}
