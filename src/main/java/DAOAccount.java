import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAccount implements DAOinterface {
    @Override
    public User foundByID(int id) {
        return null;
    }


    @Override
    public List<Account> allAccounts() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from account");
            List outList = new ArrayList();
            while (rs.next()) {
                outList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            st.close();
            con.close();
            return outList;
        } catch (ClassNotFoundException ex1) {
            System.out.println("classnotFound EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return null;
    }
}
