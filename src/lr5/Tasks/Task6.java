package lr5.Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        int divisor = 3;

        List<Integer> filteredList = filterDivisibleNumbers(inputList, divisor);

        System.out.println("Числа, делящиеся на " + divisor + " без остатка:");
        filteredList.forEach(System.out::println);
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> list, int divisor) {
        return list.stream()
                .filter(num -> num % divisor == 0)
                .collect(Collectors.toList());
    }
}
