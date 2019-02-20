package org.facet.working;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/stankin_db";

    /**
     * User and Password
     */
    private static final String USER = "faceted";
    private static final String PASSWORD = "Aa123456!";
    private static Connection connection;

    public Connection DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.getException();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        }
        catch (SQLException e) {
            e.getErrorCode();
        }

        return connection;
    }
}
