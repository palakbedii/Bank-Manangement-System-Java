import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Root@52545");
        System.out.println("Connected Successfully!");
        con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
