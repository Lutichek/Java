package lr7.Example5;

import java.io.*;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/Example5/input_file.txt";
        String outputFileName = "C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/Example5/output_file.txt";
        try (InputStream inputStream = new FileInputStream(inputFileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             OutputStream outputStream = new FileOutputStream(outputFileName);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}

