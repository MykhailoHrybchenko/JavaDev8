package org.example.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String dbUrl = "jdbc:h2:C:/Users/Asus/DataBases/h2";

    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(dbUrl, "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
