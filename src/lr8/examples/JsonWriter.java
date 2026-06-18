package lr8.examples;

import lr8.model.Product;
import lr8.util.Workspace;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class JsonWriter {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", "Продукты", 89.9));
        products.add(new Product("Тетрадь", "Канцтовары", 35.0));
        products.add(new Product("Батарейки", "Электроника", 210.0));

        JSONArray array = new JSONArray();
        for (Product product : products) {
            JSONObject node = new JSONObject();
            node.put("name", product.getName());
            node.put("category", product.getCategory());
            node.put("price", product.getPrice());
            array.add(node);
        }

        JSONObject root = new JSONObject();
        root.put("products", array);

        Path target = Workspace.file("shopping-list.json");
        try (BufferedWriter writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            writer.write(root.toJSONString());
        }

        System.out.println("JSON-файл создан: " + target.toAbsolutePath());
        System.out.println(root.toJSONString());
    }
}
