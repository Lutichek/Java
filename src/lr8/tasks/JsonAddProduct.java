package lr8.tasks;

import lr8.examples.JsonWriter;
import lr8.model.Product;
import lr8.util.Workspace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class JsonAddProduct {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наименование: ");
        String name = askText(scanner, "Сахар");
        System.out.print("Категория: ");
        String category = askText(scanner, "Продукты");
        System.out.print("Цена: ");
        double price = askPrice(scanner, 79.0);

        Product product = new Product(name, category, price);

        Path file = Workspace.file("shopping-list.json");
        if (!Files.exists(file)) {
            JsonWriter.main(new String[0]);
        }

        JSONObject root;
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            root = (JSONObject) new JSONParser().parse(reader);
        }

        JSONArray array = (JSONArray) root.get("products");
        JSONObject node = new JSONObject();
        node.put("name", product.getName());
        node.put("category", product.getCategory());
        node.put("price", product.getPrice());
        array.add(node);

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(root.toJSONString());
        }

        System.out.println("Добавлена позиция: " + product);
        System.out.println("Всего позиций: " + array.size());
    }

    private static String askText(Scanner scanner, String byDefault) {
        if (!scanner.hasNextLine()) {
            return byDefault;
        }
        String value = scanner.nextLine().trim();
        return value.isEmpty() ? byDefault : value;
    }

    private static double askPrice(Scanner scanner, double byDefault) {
        String text = askText(scanner, String.valueOf(byDefault));
        try {
            return Double.parseDouble(text.replace(',', '.'));
        } catch (NumberFormatException ex) {
            return byDefault;
        }
    }
}
