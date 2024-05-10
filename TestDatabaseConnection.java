import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testms?useSSL=false";
        String user = "root";
        String password = "rootpassword";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to MySQL database. Server version: " + conn.getMetaData().getDatabaseProductName());

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT database();");
            if (rs.next()) {
                System.out.println("You're connected to database: " + rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
