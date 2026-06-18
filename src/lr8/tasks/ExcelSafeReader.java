package lr8.tasks;

import lr8.examples.ExcelWriter;
import lr8.util.Workspace;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class ExcelSafeReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя листа для чтения: ");
        String sheetName = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        if (sheetName.isEmpty()) {
            sheetName = "Покупки";
        }

        Path file = Workspace.file("shopping-list.xlsx");
        if (!Files.exists(file)) {
            System.out.println("Файл не найден, создаю демонстрационный...");
            try {
                ExcelWriter.main(new String[0]);
            } catch (Exception ex) {
                System.out.println("Не удалось создать файл: " + ex.getMessage());
                return;
            }
        }

        try (InputStream input = Files.newInputStream(file);
             Workbook workbook = new XSSFWorkbook(input)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Лист \"" + sheetName + "\" не найден. Доступные листы:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.out.println("  - " + workbook.getSheetName(i));
                }
                return;
            }

            System.out.println("Чтение листа: " + sheetName);
            for (Row row : sheet) {
                StringBuilder line = new StringBuilder();
                for (Cell cell : row) {
                    if (line.length() > 0) {
                        line.append(" | ");
                    }
                    line.append(readCell(cell));
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла: " + ex.getMessage());
            System.out.println("Проверьте, что файл имеет формат .xlsx и не повреждён.");
        } catch (Exception ex) {
            System.out.println("Непредвиденная ошибка: "
                    + ex.getClass().getSimpleName() + " — " + ex.getMessage());
        }
    }

    private static String readCell(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
