package Servlets;

import DAO_things.DAOuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindByID")
public class FindByID extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOuser du = new DAOuser();
        try {
            int i = Integer.parseInt(request.getParameter("userID"));
            request.setAttribute("findbyid", du.foundByID(i));
            request.getRequestDispatcher("/StartJSP.jsp").forward(request, response);
        } catch (ArithmeticException ex) {
            System.out.println("ИСКЛЮЧЕНИЕ! " + ex.getMessage());
        }
    }
}
