package core;

import interfaces.CoreInterfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ObjectHelper extends CoreField implements CoreInterfaces {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=StockandSale;user=sa;password=154344;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver bulunamadı: " + e.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Veritabanı bağlantısı başarılı!");
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
        }

        return connection;
    }
}
