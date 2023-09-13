/**
 * The `PropertyReader` class provides utility methods for reading property values from a configuration file or system properties.
 * It is used to retrieve configuration settings such as browser type and base URL for a testing environment.
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    /**
     * Retrieves a property value based on the given property name. If the property is not found in the system properties,
     * it attempts to retrieve it from a configuration file.
     *
     * @param propertyName The name of the property to retrieve.
     * @return The value of the property.
     */
    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    /**
     * Retrieves a property value from a configuration file.
     *
     * @param propertyName The name of the property to retrieve.
     * @return The value of the property.
     */
    private static String getPropertyFromFile(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src\\test\\resources\\general.properties");
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("Cannot read property value for " + propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }

    /**
     * Retrieves the browser type configuration from the property file or system properties.
     *
     * @return The browser type.
     */
    public static String getBrowserType() {
        return getProperty("browser");
    }

    /**
     * Retrieves the base URL configuration from the property file or system properties.
     *
     * @return The base URL.
     */
    public static String getBaseUrl() {
        return getProperty("url.base");
    }
}
