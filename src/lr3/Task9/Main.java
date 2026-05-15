package lr3.Task9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Количество элементов
        int size = 12 * 1_000_000;

        // Создание коллекций
        List<Integer> arrayList = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // Заполнение коллекций
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            treeMap.put(i, i);
            arrayDeque.addLast(i); 
        }

        // ArrayList
        System.out.println("ArrayList");

        // Добавление в начало
        long start = System.nanoTime();
        arrayList.add(0, -1);
        long end = System.nanoTime();
        System.out.println("ArrayList добавление в начало: " + (end - start) + " ns");

        // Добавление в конец
        start = System.nanoTime();
        arrayList.add(-2);
        end = System.nanoTime();
        System.out.println("ArrayList добавление в конец: " + (end - start) + " ns");

        // Добавление в середину
        start = System.nanoTime();
        arrayList.add(size / 2, -3);
        end = System.nanoTime();
        System.out.println("ArrayList добавление в середину: " + (end - start) + " ns");

        // Удаление из начала
        start = System.nanoTime();
        arrayList.remove(0);
        end = System.nanoTime();
        System.out.println("ArrayList удаление из начала: " + (end - start) + " ns");

        // Удаление с конца
        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        end = System.nanoTime();
        System.out.println("ArrayList удаление с конца: " + (end - start) + " ns");

        // Удаление из середины
        start = System.nanoTime();
        arrayList.remove(size / 2);
        end = System.nanoTime();
        System.out.println("ArrayList удаление из середины: " + (end - start) + " ns");

        // Получение элемента по индексу
        start = System.nanoTime();
        arrayList.get(size / 2);
        end = System.nanoTime();
        System.out.println("ArrayList получение по индексу: " + (end - start) + " ns");

        // TreeMap
        System.out.println("\nTreeMap");

        // Добавление элемента в "начало"
        start = System.nanoTime();
        treeMap.put(-1, -1);
        end = System.nanoTime();
        System.out.println("TreeMap добавление в начало: " + (end - start) + " ns");

        // Добавление элемента в "конец"
        start = System.nanoTime();
        treeMap.put(size, size);
        end = System.nanoTime();
        System.out.println("TreeMap добавление в конец: " + (end - start) + " ns");

        // Добавление элемента в "середину"
        start = System.nanoTime();
        treeMap.put(size / 2 + 100_000, size / 2 + 100_000);  // уникальный ключ
        end = System.nanoTime();
        System.out.println("TreeMap добавление в середину: " + (end - start) + " ns");

        // Удаление элемента из "начала"
        start = System.nanoTime();
        treeMap.remove(-1);
        end = System.nanoTime();
        System.out.println("TreeMap удаление из начала: " + (end - start) + " ns");

        // Удаление элемента с "конца"
        start = System.nanoTime();
        treeMap.remove(size);
        end = System.nanoTime();
        System.out.println("TreeMap удаление с конца: " + (end - start) + " ns");

        // Удаление элемента из "середины"
        start = System.nanoTime();
        treeMap.remove(size / 2 + 100_000);
        end = System.nanoTime();
        System.out.println("TreeMap удаление из середины: " + (end - start) + " ns");

        // Получение элемента по ключу
        start = System.nanoTime();
        treeMap.get(size / 2);
        end = System.nanoTime();
        System.out.println("TreeMap получение по ключу: " + (end - start) + " ns");

        // Получение элемента по индексу
        start = System.nanoTime();
        Iterator<Integer> it = treeMap.keySet().iterator();
        for (int i = 0; i < size / 2; i++) {
            it.next();
        }
        it.next();
        end = System.nanoTime();
        System.out.println("TreeMap получение по индексу: " + (end - start) + " ns");

        // ArrayDeque
        System.out.println("\nArrayDeque");

        // Добавление в начало
        start = System.nanoTime();
        arrayDeque.addFirst(-1);
        end = System.nanoTime();
        System.out.println("ArrayDeque добавление в начало: " + (end - start) + " ns");

        // Добавление в конец
        start = System.nanoTime();
        arrayDeque.addLast(-2);
        end = System.nanoTime();
        System.out.println("ArrayDeque добавление в конец: " + (end - start) + " ns");

        // Добавление в середину – отсутствует, измеряем обычное addLast
        start = System.nanoTime();
        arrayDeque.addLast(-3);
        end = System.nanoTime();
        System.out.println("ArrayDeque добавление в середину: " + (end - start) + " ns");

        // Удаление из начала
        start = System.nanoTime();
        arrayDeque.removeFirst();
        end = System.nanoTime();
        System.out.println("ArrayDeque удаление из начала: " + (end - start) + " ns");

        // Удаление с конца
        start = System.nanoTime();
        arrayDeque.removeLast();
        end = System.nanoTime();
        System.out.println("ArrayDeque удаление с конца: " + (end - start) + " ns");

        // Удаление из середины – через итератор
        start = System.nanoTime();
        Iterator<Integer> itDeque = arrayDeque.iterator();
        for (int i = 0; i < size / 2; i++) {
            itDeque.next();
        }
        itDeque.remove();
        end = System.nanoTime();
        System.out.println("ArrayDeque удаление из середины: " + (end - start) + " ns");

        // Получение элемента по индексу
        start = System.nanoTime();
        itDeque = arrayDeque.iterator();
        for (int i = 0; i < size / 2; i++) {
            itDeque.next();
        }
        int middleElement = itDeque.next();
        end = System.nanoTime();
        System.out.println("ArrayDeque получение по индексу: " + (end - start) + " ns");
    }
}