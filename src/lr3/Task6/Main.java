package lr3.Task6;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество человек: ");
        int N = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        int index = 0;
        long start = System.nanoTime();
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        long end = System.nanoTime();
        System.out.println("Остался человек под номером: " + list.get(0));
        System.out.println("Время ArrayList в нс: " + (end - start));


        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list1.add(i);
        }
        int index1 = 0;
        long start1 = System.nanoTime();
        while (list1.size() > 1) {
            index1 = (index1 + 1) % list1.size();
            list1.remove(index1);
        }
        long end1 = System.nanoTime();
        System.out.println("Остался человек с номером: " + list1.get(0));
        System.out.println("Время LinkedList в нс: " + (end1 - start1));
    }
}