package lr8.examples;

import lr8.util.Workspace;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;


public class ExcelReader {

    public static void main(String[] args) throws Exception {
        Path source = Workspace.file("shopping-list.xlsx");
        if (!Files.exists(source)) {
            ExcelWriter.main(new String[0]);
        }

        try (InputStream input = Files.newInputStream(source);
             Workbook workbook = new XSSFWorkbook(input)) {

            Sheet sheet = workbook.getSheet("Покупки");
            for (Row row : sheet) {
                StringBuilder line = new StringBuilder();
                for (Cell cell : row) {
                    if (line.length() > 0) {
                        line.append("\t");
                    }
                    line.append(readCell(cell));
                }
                System.out.println(line);
            }
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
