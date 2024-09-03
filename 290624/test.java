import java.util.*;
import java.sql.*;

public class test {
    public int a;
    static void print(ResultSet res) throws SQLException {

        System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3));

    }

    public static void main(String args[]) throws SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/javatest";
        String username = "root";
        String password = "Fedora@8079";
        Connection con;

        con = DriverManager.getConnection(jdbcURL, username, password);
        Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = stmt.executeQuery("select * from customers");
        System.out.println("Connected");

        Scanner scanner = new Scanner(System.in);
        resultSet.first();
        print(resultSet);
        String s;
        System.out.println(
                "Navigation Commands:\no	[N]ext: Move to the next record.\no	[P]revious: Move to the previous record.\no	[F]irst: Move to the first record.\no	[L]ast: Move to the last record.\no	[E]xit: Exit the application.\no	[I]nsert: Insert a new record\no	[D]elete: Delete the record\n");
        Boolean flag = true;
        while (flag) {
            System.out.println("Enter Command : ");
            s = scanner.next();
            switch (s) {
                case "N":
                    try {
                        resultSet.next();
                        print(resultSet);
                    } catch (SQLException e) {
                        System.out.println("Invalid move. . ");
                    }

                    break;
                case "P":
                    try {
                        resultSet.previous();
                        print(resultSet);
                    } catch (SQLException e) {
                        System.out.println("Invalid move. . ");
                    }
                    break;

                case "E":
                    System.out.println("Exitng. . ");
                    flag = false;
                    break;

                case "F":
                    resultSet.first();
                    print(resultSet);
                    break;

                case "L":
                    resultSet.last();
                    print(resultSet);
                    break;

                case "I":
                    String name = scanner.next();
                    String email = scanner.next();
                    String phone = scanner.next();
                    resultSet.moveToInsertRow();
                    resultSet.updateString(2, name);
                    resultSet.updateString(3, email);
                    resultSet.updateString(4, phone);
                    resultSet.insertRow();
                    resultSet.moveToCurrentRow();
                    break;
                case "D":
                    resultSet.deleteRow();
                    break;
                default:
                    System.out.println("Incorrect Input,Try again");
            }

        }
        scanner.close();
    }
}