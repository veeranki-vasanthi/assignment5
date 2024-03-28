import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDBManager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "vasanthi@12345678";

    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            // Retrieving department records
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department_data");

            // Printing department records
            System.out.println("Department records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("department_name");
                System.out.println("Department ID: " + id + ", Name: " + name);
            }

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}