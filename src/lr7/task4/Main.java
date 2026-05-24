package lr7.task4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/task4/input_file.txt");
        FileWriter writer = new FileWriter("C:/Users/Biostar/Desktop/ДЗ_Java/ДЗ_1/java-core_2025-2026/src/lr7/task4/output_file.txt");
        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }
        reader.close();
        writer.close();
        System.out.println("Файл скопирован успешно!");
    }
}
