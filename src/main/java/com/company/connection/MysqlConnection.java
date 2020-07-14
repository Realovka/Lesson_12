package com.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private  static final String URL="jdbc:mysql://localhost/shop_car?serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="Vorobei55";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
