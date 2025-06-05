import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Represents a single database connection
public class DBConnection {
    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testing_db?useSSL=false";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Failed to connect to the database.");
            throw new RuntimeException("Error initializing database connection", e);
        }
    }
}
