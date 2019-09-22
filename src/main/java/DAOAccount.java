import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAccount implements DAOinterface {
    @Override
    public User foundByID(int id) {
        return null;
    }

    public User findRichest() {
        User user = new User();
        int acc = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.userid = account.userid");
            while (rs.next()) {
                if (rs.getInt("account") > acc) {
                    acc = rs.getInt("account");
                }
            }
            rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.userid = account.userid where account.account=" + acc);
            while (rs.next()) {

                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurName(rs.getString(3));

                //        return rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getInt(6);
            }
        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return user;
    }

    public String totalBank() {
        int summ = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.userid = account.userid");
            while (rs.next()) {
                summ += rs.getInt("account");
            }
            return "" + summ;
        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return null;
    }

    @Override
    public List<Account> allAccounts() {
        List outList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from account");
            while (rs.next()) {
                outList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            rs.close();
            st.close();
            con.close();
            return outList;
        } catch (ClassNotFoundException ex1) {
            System.out.println("classnotFound EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return outList;
    }
}
