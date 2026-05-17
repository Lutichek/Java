package lr5.Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "orange", "kiwi", "grape");
        String substring = "an";
        System.out.println("Список до: " + strings);
        List<String> filteredStrings = filterStrings(strings, substring);
        System.out.println("Список после: " + filteredStrings);
    }

    public static List<String> filterStrings(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }
}

