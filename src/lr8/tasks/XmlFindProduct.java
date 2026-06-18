package lr8.tasks;

import lr8.examples.XmlReader;
import lr8.examples.XmlWriter;
import lr8.model.Product;
import lr8.util.Workspace;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class XmlFindProduct {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите категорию или цену для поиска: ");
        String query = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        if (query.isEmpty()) {
            query = "Продукты";
        }

        Path file = Workspace.file("shopping-list.xml");
        if (!Files.exists(file)) {
            XmlWriter.main(new String[0]);
        }

        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(file.toFile());
        NodeList nodes = document.getElementsByTagName("product");

        List<Product> all = new ArrayList<>();
        for (int index = 0; index < nodes.getLength(); index++) {
            all.add(XmlReader.readProduct((Element) nodes.item(index)));
        }

        final String needle = query;
        List<Product> matched = all.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(needle)
                        || String.valueOf(product.getPrice()).equals(needle))
                .collect(Collectors.toList());

        System.out.println("Запрос: \"" + query + "\". Найдено: " + matched.size());
        for (Product product : matched) {
            System.out.println(" -> " + product);
        }
    }
}
