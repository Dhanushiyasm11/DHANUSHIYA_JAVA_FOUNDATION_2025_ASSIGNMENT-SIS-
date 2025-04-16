package com.hexaware.oms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    
    public static String getConnectionString(String fileName) throws IOException {
        Properties properties = new Properties();

      
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
        }

        
        return properties.getProperty("db.url");
    }
}
