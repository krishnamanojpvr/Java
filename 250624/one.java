import java.io.*;
import java.sql.*;

public class one {
    public static void main(String[] args) {
        String fileName = "smartphones.csv";
        String jdbcURL = "jdbc:mysql://localhost:3306/smartphones";
        String username = "root";
        String password = "Fedora@8079";

        // String createTableSQL = "CREATE TABLE IF NOT EXISTS phone ("
        //         + "serial INT NOT NULL AUTO_INCREMENT, "
        //         + "smartphone VARCHAR(100), "
        //         + "brand VARCHAR(100), "
        //         + "model VARCHAR(100), "
        //         + "ram INT DEFAULT 0, "
        //         + "storage INT DEFAULT 0, "
        //         + "color VARCHAR(100), "
        //         + "free BOOLEAN DEFAULT FALSE, "
        //         + "final_price DOUBLE DEFAULT 0.0, "
        //         + "PRIMARY KEY (serial))";

        // String insertSQL = "INSERT INTO phone (smartphone, brand, model, ram, storage, color, free, final_price) "
        //         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
                Connection con = DriverManager.getConnection(jdbcURL, username, password);
                Statement stmt = con.createStatement()) {

        //     System.out.println("Connected");

        //     // Create table if it doesn't exist
        //     stmt.executeUpdate(createTableSQL);

        //     try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
        //         // Skip the header line
        //         br.readLine();

        //         String line;
        //         while ((line = br.readLine()) != null) {
        //             String[] columns = line.split(",");
        //             if (columns.length < 8) {
        //                 continue; // Skip invalid rows
        //             }

        //             // Set values, allowing defaults to take effect for empty strings
        //             pstmt.setString(1, columns[0]);
        //             pstmt.setString(2, columns[1]);
        //             pstmt.setString(3, columns[2]);
        //             pstmt.setObject(4, columns[3].isEmpty() ? null : Integer.parseInt(columns[3]), Types.INTEGER);
        //             pstmt.setObject(5, columns[4].isEmpty() ? null : Integer.parseInt(columns[4]), Types.INTEGER);
        //             pstmt.setString(6, columns[5]);
        //             pstmt.setObject(7, columns[6].isEmpty() ? null : Boolean.parseBoolean(columns[6]), Types.BOOLEAN);
        //             pstmt.setObject(8, columns[7].isEmpty() ? null : Double.parseDouble(columns[7]), Types.DOUBLE);

        //             pstmt.executeUpdate();
        //         }
        //     }
            System.out.println("Data has been inserted successfully.");
            // a.total no. of iphones
            ResultSet r1 = stmt.executeQuery("select smartphone from phone where brand = 'Apple'");
            while(r1.next()){
                System.out.println(r1.getString(1));
            }
            // b.phone names of all phones within 500 along with model number
            ResultSet r2 = stmt.executeQuery("select smartphone, model from phone where final_price <= 500");
            while(r2.next()){
                System.out.println(r2.getString(1) + " " + r2.getString(2));
            }
            // c.all models belonging to brand samsung
            ResultSet r3 = stmt.executeQuery("select model from phone where brand = 'Samsung'");
            while(r3.next()){
                System.out.println(r3.getString(1));
            }
            // d.cheapest phone in Nothing brand
            ResultSet r4 = stmt.executeQuery("select smartphone, model, final_price from phone where brand = 'Nothing' order by final_price limit 1");
            while(r4.next()){
                System.out.println(r4.getString(1) + " " + r4.getString(2) + " " + r4.getDouble(3));
            }
            // e.sorted phones in the order of price range
            ResultSet r5 = stmt.executeQuery("select smartphone, model, final_price from phone order by final_price");
            while(r5.next()){
                System.out.println(r5.getString(1) + " " + r5.getString(2) + " " + r5.getDouble(3));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Number format exception: " + e.getMessage());
        }
    }
}
