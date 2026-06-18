package lr8.tasks;

import lr8.examples.XmlWriter;
import lr8.model.Product;
import lr8.util.Workspace;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class XmlAddProduct {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наименование: ");
        String name = askText(scanner, "Кофе");
        System.out.print("Категория: ");
        String category = askText(scanner, "Продукты");
        System.out.print("Цена: ");
        double price = askPrice(scanner, 549.0);

        Product product = new Product(name, category, price);

        Path file = Workspace.file("shopping-list.xml");
        if (!Files.exists(file)) {
            XmlWriter.main(new String[0]);
        }

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(file.toFile());
        Element root = document.getDocumentElement();

        Element item = document.createElement("product");
        addField(document, item, "name", product.getName());
        addField(document, item, "category", product.getCategory());
        addField(document, item, "price", String.valueOf(product.getPrice()));
        root.appendChild(item);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(file.toFile()));

        System.out.println("Добавлена позиция: " + product);
        System.out.println("Всего позиций: " + document.getElementsByTagName("product").getLength());
    }

    private static void addField(Document document, Element parent, String tag, String value) {
        Element field = document.createElement(tag);
        field.setTextContent(value);
        parent.appendChild(field);
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
            System.out.println("Цена введена некорректно, использую " + byDefault);
            return byDefault;
        }
    }
}
