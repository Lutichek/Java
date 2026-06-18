package Timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Task1001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }

        StringBuilder output = new StringBuilder();
        for (int index = numbers.size() - 1; index >= 0; index--) {
            double root = Math.sqrt(numbers.get(index));
            output.append(String.format(Locale.US, "%.4f", root));
            output.append(System.lineSeparator());
        }

        System.out.print(output);
    }
}
