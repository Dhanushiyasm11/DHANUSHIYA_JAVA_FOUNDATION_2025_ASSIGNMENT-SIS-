package com.hexaware.oms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class DBConnUtil {

    
    public static Connection getDBConn(String propertiesFile) throws SQLException, IOException {
       
        String connectionString = DBPropertyUtil.getConnectionString(propertiesFile);

        
        String username = "root";  
        String password = "Dhanushiya@dhanu";  
      
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

     
        return DriverManager.getConnection(connectionString, username, password);
    }
}
