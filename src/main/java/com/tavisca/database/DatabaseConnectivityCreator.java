package com.tavisca.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivityCreator {
    private static Connection conn;

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if(conn == null){
            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/datasource","root","root");
        }
        return conn;
    }

}
