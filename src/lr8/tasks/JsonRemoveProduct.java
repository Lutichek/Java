package lr8.tasks;

import lr8.examples.JsonWriter;
import lr8.util.Workspace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;


public class JsonRemoveProduct {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наименование для удаления: ");
        String name = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        if (name.isEmpty()) {
            name = "Тетрадь";
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
        int before = array.size();

        Iterator<?> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject node = (JSONObject) iterator.next();
            if (name.equalsIgnoreCase(String.valueOf(node.get("name")))) {
                iterator.remove();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(root.toJSONString());
        }

        System.out.println("Удалено позиций: " + (before - array.size()));
        System.out.println("Осталось позиций: " + array.size());
    }
}
