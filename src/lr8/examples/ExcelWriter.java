package lr8.examples;

import lr8.model.Product;
import lr8.util.Workspace;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class ExcelWriter {

    private static final String SHEET = "Покупки";

    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", "Продукты", 89.90));
        products.add(new Product("Ноутбук", "Электроника", 74990.00));

        Path target = Workspace.file("shopping-list.xlsx");

        Workbook workbook = new XSSFWorkbook();
        try {
            Sheet sheet = workbook.createSheet(SHEET);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Наименование");
            header.createCell(1).setCellValue("Категория");
            header.createCell(2).setCellValue("Цена");

            int rowNumber = 1;
            for (Product product : products) {
                Row row = sheet.createRow(rowNumber);
                row.createCell(0).setCellValue(product.getName());
                row.createCell(1).setCellValue(product.getCategory());
                row.createCell(2).setCellValue(product.getPrice());
                rowNumber++;
            }

            try (OutputStream output = Files.newOutputStream(target)) {
                workbook.write(output);
            }
        } finally {
            workbook.close();
        }

        System.out.println("Excel-файл создан: " + target.toAbsolutePath());
        System.out.println("Строк с данными: " + products.size());
    }
}
