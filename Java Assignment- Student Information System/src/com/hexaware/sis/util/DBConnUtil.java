package com.hexaware.sis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DBConnUtil {

    public static Connection getConnection(String fileName) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(fileName));

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}


