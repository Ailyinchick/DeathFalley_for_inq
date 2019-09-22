import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {

    static final String JDBC_driver = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbfordv";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123qwe";
    static final String Select_all_accounts = "select * from account";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //     PrintWriter writer = response.getWriter();
        //     writer.println(da.findRichest());


        DAOAccount da = new DAOAccount();
        request.setAttribute("name", da.findRichest().getName());
        request.getRequestDispatcher("/StartJSP.jsp").forward(request, response);
    }
}
