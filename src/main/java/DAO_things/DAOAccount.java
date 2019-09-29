package DAO_things;

import SourcePack.Account;
import SourcePack.User;
import SourcePack.userWallet;

import java.sql.*;
import java.util.*;

public class DAOAccount implements DAOinterface {
    @Override
    public User foundByID(int id) {
        return null;
    }

    public void tableSummAcc() {
        List<userWallet> outList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();

          /*  st.executeUpdate("drop table accsumm");
            st.executeUpdate("create table if not exists accsumm(userid int, totalcash int )");
            st.executeUpdate("truncate table accsum");*/

            ResultSet rs = st.executeQuery("select userid from account order by userid");
            Set varSet = new LinkedHashSet();
            while (rs.next()) {
                varSet.add(new userWallet(rs.getInt(1)));
            }


            List<userWallet> varList = new ArrayList(varSet);
            for (int i = 0; i < varList.size(); i++) {
                rs = st.executeQuery("select account, userid from account where userid=" + varList.get(i).getUserid() + " order by userid");
                while (rs.next()) {
                    varList.get(i).cash += rs.getInt(1);
                }
            }
            for (int i = 0; i < varList.size(); i++) {
                st.executeUpdate("insert into accsumm values(" + varList.get(i).getUserid() + ", " + varList.get(i).getCash() + ") ");
            }

        } catch (ClassNotFoundException ex1) {
            System.out.println("ClassNOtFoundEX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println(ex2.getMessage());
        }

    }

    public User findRichest() {
        User user = new User();
        int usid=0;
        int acc = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbfordv", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from accsumm");
            while (rs.next()) {
                if (rs.getInt(2) > acc) {
                    acc = rs.getInt(2);
                    usid=rs.getInt(1);
                }
            }
            rs = st.executeQuery("SELECT * FROM user LEFT OUTER JOIN account ON user.userid = account.userid where user.userid=" + usid);
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurName(rs.getString(3));
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
