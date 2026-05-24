package lr7;

import java.io.*;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        String fileName = "Example_4_file.txt";
        String data;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные для записи: ");
        data = in.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        if (new File(fileName).delete()) {
            System.out.println("файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
        in.close();
    }
}
