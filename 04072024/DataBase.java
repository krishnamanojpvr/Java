import java.sql.*;

public class DataBase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/fourjuly";
        String username = "root";
        String password = "Fedora@8079";

        Connection connection = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false); // Set auto-commit to off

            // Insert operation
            String insertSQL = "INSERT INTO Managers (ManagerID, FirstName, LastName, Department, Email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSQL)) {
                insertStmt.setInt(1, 11);
                insertStmt.setString(2, "Peter");
                insertStmt.setString(3, "Parker");
                insertStmt.setString(4, "Finance");
                insertStmt.setString(5, "peter.parker@bank.com");
                insertStmt.executeUpdate();
            }

            // Create a savepoint after the insert operation
            Savepoint savepoint1 = connection.setSavepoint("Savepoint1");

            // Update operation
            String updateSQL = "UPDATE Employees SET Email = ? WHERE EmployeeID = ?";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                updateStmt.setString(1, "updated.email@bank.com");
                updateStmt.setInt(2, 1);
                updateStmt.executeUpdate();
            }

            // Create another savepoint after the update operation
            Savepoint savepoint2 = connection.setSavepoint("Savepoint2");

            // Delete operation
            String deleteSQL = "DELETE FROM Users WHERE UserID = ?";
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL)) {
                deleteStmt.setInt(1, 10);
                deleteStmt.executeUpdate();
            }

            // Rollback to savepoint1 (this will undo the update and delete operations)
            connection.rollback(savepoint1);

            // Commit the transactions up to savepoint1
            connection.commit();
            System.out.println("Transaction committed successfully up to Savepoint1.");

        } catch (SQLException e) {
            // Rollback the transactions in case of an error
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
