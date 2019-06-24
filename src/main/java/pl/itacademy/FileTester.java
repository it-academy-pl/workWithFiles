package pl.itacademy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class FileTester {

    public static void main(String[] args) throws URISyntaxException, IOException {

        /*String filePath = "c:\\1\\file.txt";
        File file = new File(filePath);

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Unable to read file from Disk!");
            e.printStackTrace();
        }

        String fileToWritePath = "c:\\1\\out.txt";
        File fileToWrite = new File(fileToWritePath);

        List<String> lines = Arrays.asList("Test write to file", "Hello world!", "aaasdfasdfasdfs");

        try (FileWriter fileWriter = new FileWriter(fileToWrite);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : lines) {
                bufferedWriter.append(line);
            }
            bufferedWriter.flush();

        } catch (IOException e) {
            System.out.println("Unable to write file to Disk!");
            e.printStackTrace();
        }

        System.out.println("=== PATHS and FILES API ===");
        Path path = Paths.get("c:\\1\\file.txt");
        try {
            Files.readAllLines(path)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*FileTester fileTester = new FileTester();
        URL applicationPropertiesUrl = fileTester.getClass().getClassLoader().getResource("application.properties");
        File applicationPropertiesFile = new File(applicationPropertiesUrl.toURI());
        Properties properties = new Properties();
        properties.load(new FileReader(applicationPropertiesFile));

        Path appPropertiesPath = Paths.get(applicationPropertiesUrl.toURI());
        Properties properties1 = new Properties();
        properties1.load(Files.newInputStream(appPropertiesPath));

        System.out.println(properties.getProperty("application.number.example1", "no value"));
*/

        /*String firstPropertiesLocation = "./application.properties";
        Path firstPropertiesPath = Paths.get(firstPropertiesLocation);

        String secondPropertiesLocation = "./config/application.properties";
        Path secondPropertiesPath = Paths.get(secondPropertiesLocation);
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(firstPropertiesPath);
        } catch (IOException e) {
            try {
                inputStream = Files.newInputStream(secondPropertiesPath);
            } catch (IOException e1) {
                FileTester fileTester = new FileTester();
                URL resource = fileTester.getClass().getClassLoader().getResource("application.properties");
                URI uri = resource.toURI();
                String[] array = uri.toString().split("!");
                FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), new HashMap<>());
                Path jarPath = fs.getPath(array[1]);

                inputStream = Files.newInputStream(jarPath);
            }
        }

        if(inputStream != null) {
            Properties properties = new Properties();
            properties.load(inputStream);

            System.out.println(properties.getProperty("java.version"));
        }*/


        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello Excel!");

        Path path = Paths.get("c:\\1\\demo.xslx");
        OutputStream outputStream = Files.newOutputStream(path);

        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }
}
