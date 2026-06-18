package lr8.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlLinkParser {

    public static void main(String[] args) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");
        html.append("<h1>Магазин</h1>");
        html.append("<a href=\"https://itlearn.ru/first-steps\">Первые шаги</a>");
        html.append("<a href=\"https://jsoup.org/\">Jsoup</a>");
        html.append("<a href=\"/catalog\">Каталог</a>");
        html.append("</body></html>");

        Document document = Jsoup.parse(html.toString(), "https://itlearn.ru/");
        Elements links = document.select("a[href]");

        System.out.println("Найдено ссылок: " + links.size());
        for (Element link : links) {
            System.out.println(link.text() + " -> " + link.attr("abs:href"));
        }
    }
}
