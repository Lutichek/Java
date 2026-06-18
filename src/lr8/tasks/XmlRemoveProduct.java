package lr8.tasks;

import lr8.examples.XmlReader;
import lr8.examples.XmlWriter;
import lr8.util.Workspace;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class XmlRemoveProduct {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наименование для удаления: ");
        String name = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        if (name.isEmpty()) {
            name = "Хлеб";
        }

        Path file = Workspace.file("shopping-list.xml");
        if (!Files.exists(file)) {
            XmlWriter.main(new String[0]);
        }

        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(file.toFile());
        NodeList nodes = document.getElementsByTagName("product");

        int removed = 0;
        for (int index = nodes.getLength() - 1; index >= 0; index--) {
            Element item = (Element) nodes.item(index);
            if (XmlReader.readTag(item, "name").equalsIgnoreCase(name)) {
                item.getParentNode().removeChild(item);
                removed++;
            }
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(file.toFile()));

        System.out.println("Удалено позиций \"" + name + "\": " + removed);
        System.out.println("Осталось позиций: " + document.getElementsByTagName("product").getLength());
    }
}
