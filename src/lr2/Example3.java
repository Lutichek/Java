package lr2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для шифрования:");
        String message = scanner.nextLine();
        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine();

        String encodedMessage = encode(message, key);
        System.out.println("Текст после преобразования: " + encodedMessage);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("y")) {
            String decodedMessage = decode(encodedMessage, key);
            System.out.println("Текст после обратного преобразования: " + decodedMessage);
        } else if (response.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }

    private static String encode(String message, int key) {
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) (((ch - base + key) % 26) + base);
            }
            encodedMessage.append(ch);
        }
        return encodedMessage.toString();
    }

    private static String decode(String message, int key) {
        return encode(message, 26 - key);
    }
}
