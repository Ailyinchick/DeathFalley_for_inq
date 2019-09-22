
import java.sql.*;
import java.util.List;

public class DAOuser implements DAOinterface {
    @Override
    public User foundByID(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.userid = account.userid where user.userid="+id);

            //ResultSet rs = st.executeQuery("select * from user where userid=" + id);
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException ex1) {
            System.out.println("ex1 " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("ex2 " + ex2.getMessage());
        }
        return null;
    }

    @Override
    public List<Account> allAccounts() {
        return null;
    }
}
