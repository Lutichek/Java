package lr3.Task5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");

        String result = "";
        int product = 1;

        for (Integer key : map.keySet()) {
            if (key > 5) {
                System.out.println(map.get(key));
            } else if (key == 0) {
                result = String.join(", ", map.values());
            }

            if (map.get(key).length() > 5) {
                product *= key;
            }
        }

        System.out.println("Результат: " + result);
        System.out.println("Произведение ключей с длиной строки больше 5: " + product);
    }
}