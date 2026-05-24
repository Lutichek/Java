package lr7.task3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/task3/input_file.txt";
        BufferedReader reader =
                new BufferedReader(
                        new FileReader(fileName));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        System.out.println("Количество строк в файле: " + lineCount);
    }
}
