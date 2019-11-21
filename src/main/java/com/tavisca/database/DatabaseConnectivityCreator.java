package com.tavisca.database;

import com.tavisca.service.GetPropertyFileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectivityCreator {
    private static Connection conn;

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Properties properties = GetPropertyFileReader.getInstance().readPropertyFile();
        String dbUrl =  properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");
        if(conn == null){
            conn=DriverManager.getConnection(
                    dbUrl,dbUsername,dbPassword);
        }
        return conn;
    }

}
