package pl.itacademy.util;

import pl.itacademy.FileTester;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {

    private static final String APPLICATION_PROPERTIES = "application.properties";

    private static Properties properties = new Properties();
    private static URI uri;

    public PropertiesReader() throws URISyntaxException, IOException {
        uri = this.getClass().getClassLoader()
                .getResource("application.properties").toURI();
        properties.load(Files.newInputStream(Paths.get(uri)));
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}
