package lr7.Example6;

import java.io.*;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/Example6/input_file.txt";
        String outputFileName = "C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/Example6/input_file.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter printWriter = new PrintWriter(outputFileName, "UTF-8")) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line.toUpperCase());
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
