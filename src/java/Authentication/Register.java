/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Authentication;

import controller.Utils;
import dao.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author 84352
 */
public class Register extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Utils.getAccountLogin(request) != null) {
            request.getRequestDispatcher("./view/start.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("./view/register.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int value = Integer.parseInt(request.getParameter("otp"));
        HttpSession session = request.getSession();
        int otp = (int) session.getAttribute("otp");
        if (value == otp) {
            String username = (String) session.getAttribute("email");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_password");
            if (password.equals(confirm_password)) {
                AccountDAO accountDAO = new AccountDAO();
                accountDAO.register(new Account(username, Utils.enCodePassword(password), 0));
                if (accountDAO.login(username, Utils.enCodePassword(password)) == null) {
                    request.setAttribute("mess_er", "Username is exist");
                    request.getRequestDispatcher("./view/register.jsp").forward(request, response);
                }
                request.setAttribute("mess", "Register successfully");
                request.getRequestDispatcher("./view/login.jsp").forward(request, response);

            } else {

                request.setAttribute("mess_er", "Password is not matched");
                request.getRequestDispatcher("./view/register.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("mess_er", "OTP is false");
            request.getRequestDispatcher("./view/register.jsp").forward(request, response);
        }

    }

}
