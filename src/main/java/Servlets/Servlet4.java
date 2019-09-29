package Servlets;

import DAO_things.DAOAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOAccount da = new DAOAccount();
        request.setAttribute("summ", da.totalBank());
        request.getRequestDispatcher("/StartJSP.jsp").forward(request, response);
    }
}
