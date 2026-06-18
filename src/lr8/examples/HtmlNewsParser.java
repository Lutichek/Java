package lr8.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlNewsParser {

    public static void main(String[] args) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><div class=\"news\">");
        html.append("<div class=\"item\"><span class=\"theme\">Скидки недели</span>")
                .append("<span class=\"date\">01.03.2026</span></div>");
        html.append("<div class=\"item\"><span class=\"theme\">Новый магазин</span>")
                .append("<span class=\"date\">12.04.2026</span></div>");
        html.append("<div class=\"item\"><span class=\"theme\">Акция выходного дня</span>")
                .append("<span class=\"date\">20.05.2026</span></div>");
        html.append("</div></body></html>");

        Document document = Jsoup.parse(html.toString());
        Elements items = document.select("div.item");

        System.out.println("Новостей: " + items.size());
        for (Element item : items) {
            String theme = item.selectFirst("span.theme").text();
            String date = item.selectFirst("span.date").text();
            System.out.println(date + " — " + theme);
        }
    }
}
