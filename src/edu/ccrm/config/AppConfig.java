// File: edu/ccrm/config/AppConfig.java
package edu.ccrm.config;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class AppConfig {

    private static AppConfig instance;
    private Properties properties;

    private AppConfig() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            System.err.println("Failed to load configuration properties: " + e.getMessage());
        }
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
