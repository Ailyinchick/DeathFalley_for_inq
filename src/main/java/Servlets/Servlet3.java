package Servlets;

import DAO_things.DAOAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOAccount da = new DAOAccount();
        request.setAttribute("name", da.findRichest().getName());
        request.getRequestDispatcher("/StartJSP.jsp").forward(request, response);
    }
}
