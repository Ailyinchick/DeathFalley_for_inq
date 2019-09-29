package Servlets;

import DAO_things.DAOuser;
import SourcePack.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    static final String JDBC_driver = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbfordv";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123qwe";
    static final String Select_all_accounts = "select * from account";

    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();

        String title = "Death Valley";
        String docType = "<!DOCTYPE html>";
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>" +
                "<form action='TestServlet.java' method='get'>" +
                "<input type='text' name='userID'/>" +
                "<input type = 'submit' name='Submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");

        try {
            Class.forName(JDBC_driver);
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Select_all_accounts);
            String var1 = "";

            writer.println("<h1>Choosen user info</h1>");
            DAOuser us = new DAOuser();
            var1 = request.getParameter("userID");
            User user = us.foundByID(Integer.parseInt(var1));
            writer.println("User: " + user.toString());

            writer.println("<br/>");

            writer.println("<h2>Accounts</h2>");
            writer.println("<br/>");
            while (rs.next()) {
                int accID = rs.getInt(1);
                int acc = rs.getInt(2);
                int userID = rs.getInt(3);

                writer.println("Account ID: " + accID);
                writer.println("Account: " + acc + "<br/>");
                writer.println("User ID: " + userID + "<br/>");
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("CloassNotFound EX " + e.getMessage());
        } catch (SQLException e1) {
            System.out.println("SQL EX " + e1.getMessage());
        }
        writer.println("</body></html>");
    }

    @Override
    public void destroy() {

    }
}
