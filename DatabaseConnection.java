package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private java.sql.Connection connection;


    public Connection getConnection() {
        return connection;
    }

    public void connect(String dbUrl) {
        String url = "jdbc:sqlite:" + dbUrl;
        try {
            if(connection == null) {
                connection = DriverManager.getConnection(url);
            }
            else {
                System.out.println("Już jesteś połączony!");
            }
        } catch (SQLException e) {
            System.out.println("Nawiązanie połączenia z bazą danych się nie powiodło");
        }
    }

    public void disconnect() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Próba rozłączenia z db nie zakończyła się powodzeniem");
            }
        }
    }
}
