import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseExample {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "vasanthi@12345678"; // Replace with your MySQL password
    private static final String DATABASE_NAME = "my_db"; // Specify the name of the database you want to create

    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            // Creating database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;
            statement.executeUpdate(createDatabaseQuery);

            System.out.println("Database created successfully.");

            // Closing resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}