package lr5.Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        System.out.println("Список до: " + numbers);
        int threshold = 15;
        List<Integer> filteredNumbers = filterNumbers(numbers, threshold);
        System.out.println("Список после: " + filteredNumbers);
    }

    public static List<Integer> filterNumbers(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(number -> number > threshold)
                .collect(Collectors.toList());
    }
}
