package lr8.examples;

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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class XmlWriter {

    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", "Продукты", 89.90));
        products.add(new Product("Хлеб", "Продукты", 45.50));
        products.add(new Product("Шампунь", "Бытовая химия", 320.00));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("shopping-list");
        document.appendChild(root);

        for (Product product : products) {
            Element item = document.createElement("product");
            putField(document, item, "name", product.getName());
            putField(document, item, "category", product.getCategory());
            putField(document, item, "price", String.valueOf(product.getPrice()));
            root.appendChild(item);
        }

        Path target = Workspace.file("shopping-list.xml");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(document), new StreamResult(target.toFile()));

        System.out.println("XML-файл создан: " + target.toAbsolutePath());
        System.out.println("Записано позиций: " + products.size());
    }

    private static void putField(Document document, Element parent, String tag, String value) {
        Element field = document.createElement(tag);
        field.setTextContent(value);
        parent.appendChild(field);
    }
}
