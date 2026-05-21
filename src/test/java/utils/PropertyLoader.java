package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final String BASE_PATH = "conf.properties";

    public static String getProperty (String property) {
        var properties = new Properties();

        try {
            properties.load(loadProperties());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(property);
    }

    private static InputStream loadProperties() {
        return PropertyLoader.class.getResourceAsStream("/" + BASE_PATH);
    }
}
