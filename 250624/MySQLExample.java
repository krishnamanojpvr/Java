import java.sql.*;

public class MySQLExample {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/DBMSLAB";
            String user = "root";
            String password = "Fedora@8079";
            
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // System.out.println("Connection successful!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Student");

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            
            }
            
            // Close the connection
            connection.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
