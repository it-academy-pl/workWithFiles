package pl.itacademy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import pl.itacademy.util.PropertiesReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTester {

    public static void main(String[] args) throws URISyntaxException, IOException {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println(arg);
        }

        PropertiesReader propertiesReader = new PropertiesReader();

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test sheet");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("test");

        String defaultName = propertiesReader.readProperty("excel.defaultName");
        String defaultExtension = propertiesReader.readProperty("excel.defaultExtension");
        String fullFileName = defaultName + "." + defaultExtension;
        workbook.write(Files
                .newOutputStream(
                        Paths.get("C:\\1\\" + fullFileName)));

        workbook.close();

        propertiesReader.closeReader();
    }
}
