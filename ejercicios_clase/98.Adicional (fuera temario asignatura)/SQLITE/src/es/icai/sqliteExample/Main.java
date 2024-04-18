package es.icai.sqliteExample;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        String sql = "SELECT * FROM customers";
        try {
            // db parameters
            String url = "jdbc:sqlite:./chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
                // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + "\t" +
                            rs.getString("LastName") + "\t" +
                            rs.getInt("CustomerId"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
