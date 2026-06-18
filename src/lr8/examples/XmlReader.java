package lr8.examples;

import lr8.model.Product;
import lr8.util.Workspace;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.nio.file.Files;
import java.nio.file.Path;


public class XmlReader {

    public static void main(String[] args) throws Exception {
        Path source = Workspace.file("shopping-list.xml");
        if (!Files.exists(source)) {
            XmlWriter.main(new String[0]);
        }

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(source.toFile());

        System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
        NodeList nodes = document.getElementsByTagName("product");
        System.out.println("Всего позиций: " + nodes.getLength());

        for (int index = 0; index < nodes.getLength(); index++) {
            Product product = readProduct((Element) nodes.item(index));
            System.out.println((index + 1) + ") " + product);
        }
    }

    /** Собирает объект Product из элемента <product>. */
    public static Product readProduct(Element element) {
        String name = readTag(element, "name");
        String category = readTag(element, "category");
        double price = parseDouble(readTag(element, "price"));
        return new Product(name, category, price);
    }

    public static String readTag(Element element, String tag) {
        NodeList list = element.getElementsByTagName(tag);
        if (list.getLength() == 0) {
            return "";
        }
        return list.item(0).getTextContent();
    }

    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }
}
