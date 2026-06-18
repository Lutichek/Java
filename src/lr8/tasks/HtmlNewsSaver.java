package lr8.tasks;

import lr8.util.Workspace;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class HtmlNewsSaver {

    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        List<String> news = null;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                news = parseNews();
                break;
            } catch (Exception ex) {
                System.out.println("Попытка " + attempt + " не удалась: " + ex.getMessage());
                if (attempt == MAX_ATTEMPTS) {
                    System.out.println("Превышено число попыток, выходим.");
                    return;
                }
                System.out.println("Повторное подключение...");
            }
        }

        Path target = Workspace.file("news.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            for (String line : news) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Не удалось записать файл: " + ex.getMessage());
            return;
        }

        System.out.println("Сохранено новостей: " + news.size() + " -> " + target.toAbsolutePath());
        for (String line : news) {
            System.out.println("  " + line);
        }
    }

    /** Парсит блок новостей.*/
    private static List<String> parseNews() {
        String html = "<div class=\"news\">"
                + "<div class=\"item\"><span class=\"theme\">Открытие магазина</span>"
                + "<span class=\"date\">10.05.2026</span></div>"
                + "<div class=\"item\"><span class=\"theme\">Распродажа техники</span>"
                + "<span class=\"date\">25.05.2026</span></div>"
                + "</div>";

        Document document = Jsoup.parse(html);
        Elements items = document.select("div.item");

        List<String> result = new ArrayList<>();
        for (Element item : items) {
            String theme = item.selectFirst("span.theme").text();
            String date = item.selectFirst("span.date").text();
            result.add(date + " — " + theme);
        }
        return result;
    }
}
