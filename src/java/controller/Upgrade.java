/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Upgrade extends BaseRequiredAuthentication {

      
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Account account = (Account) httpSession.getAttribute("login");
        if (account != null) {
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.upgrade(account);
            httpSession.setAttribute("login", new Account(account.getUsername(), account.getPassword(),1));

        }
        request.getRequestDispatcher("./view/upgrade.jsp").forward(request, response);
//        response.sendRedirect("home");
    }
 
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
 
}
