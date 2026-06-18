package lr8.examples;

import lr8.util.Workspace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class JsonReader {

    public static void main(String[] args) throws Exception {
        Path source = Workspace.file("shopping-list.json");
        if (!Files.exists(source)) {
            JsonWriter.main(new String[0]);
        }

        JSONObject root;
        try (BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8)) {
            root = (JSONObject) new JSONParser().parse(reader);
        }

        JSONArray array = (JSONArray) root.get("products");
        System.out.println("Позиций в JSON: " + array.size());

        int counter = 1;
        for (Object element : array) {
            JSONObject node = (JSONObject) element;
            System.out.println(counter + ". " + node.get("name")
                    + " | категория: " + node.get("category")
                    + " | цена: " + node.get("price"));
            counter++;
        }
    }
}
