package lr5.Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        List<String> inputList = List.of("apple", "banana", "orange", "kiwi", "grape");
        System.out.println("Список до: " + inputList);
        List<String> filteredList = filterStringsByLength(inputList, 5);
        System.out.println("Список после: " + filteredList);
    }

    public static List<String> filterStringsByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(str -> str.length() > minLength)
                .collect(Collectors.toList());
    }
}
