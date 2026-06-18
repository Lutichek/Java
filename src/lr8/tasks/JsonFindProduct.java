package lr8.tasks;

import lr8.examples.JsonWriter;
import lr8.util.Workspace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class JsonFindProduct {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Категория для поиска: ");
        String category = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        if (category.isEmpty()) {
            category = "Продукты";
        }

        Path file = Workspace.file("shopping-list.json");
        if (!Files.exists(file)) {
            JsonWriter.main(new String[0]);
        }

        JSONObject root;
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            root = (JSONObject) new JSONParser().parse(reader);
        }

        JSONArray array = (JSONArray) root.get("products");
        List<Object> items = array;
        final String needle = category;
        long found = items.stream()
                .filter(element -> element instanceof JSONObject)
                .map(element -> (JSONObject) element)
                .filter(node -> needle.equalsIgnoreCase(String.valueOf(node.get("category"))))
                .peek(node -> System.out.println(" -> " + node.get("name") + ", цена: " + node.get("price")))
                .count();

        System.out.println("По категории \"" + category + "\" найдено: " + found);
    }
}
