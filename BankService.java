import java.sql.*;

public class BankService {

    Connection con;

    public BankService() {
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb", "root", "Root@52545");
            System.out.println("DB Connected in Service");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE ACCOUNT
    public void createAccount(int accNo, String name, int age, int id, String type, double balance) {
        try {
            String query = "INSERT INTO accounts VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, accNo);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.setString(5, type);
            ps.setDouble(6, balance);

            ps.executeUpdate();
            System.out.println("Account Created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DEPOSIT
    public void deposit(int accNo, double amount) {
        try {
            String query = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();
            System.out.println("Amount Deposited!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // WITHDRAW
    public void withdraw(int accNo, double amount) {
        try {
            String query = "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();
            System.out.println("Amount Withdrawn!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CHECK BALANCE
    public void checkBalance(int accNo) {
        try {
            String query = "SELECT balance FROM accounts WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
