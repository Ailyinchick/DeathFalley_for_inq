package Servlets;

import DAO_things.DAOAccount;
import DAO_things.DAOuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindAll")
public class FindAll extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOuser du = new DAOuser();
        request.setAttribute("account", du.findAll());
        request.getRequestDispatcher("/StartJSP.jsp").forward(request, response);
    }
}
