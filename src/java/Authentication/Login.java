/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Authentication;

import LoginWithGoogle.GoogleDTO;
import LoginWithGoogle.GoogleSupport;
import controller.Utils;
import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Account;

/**
 *
 * @author 84352
 */
public class Login extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // login by google 
        if(Utils.getAccountLogin(request)!=null){
             request.getRequestDispatcher("./view/start.jsp").forward(request, response);
        }
        try {
            String code = request.getParameter("code");
            String accessToken = GoogleSupport.getToken(code);
            GoogleDTO user = GoogleSupport.getUserInfo(accessToken);
            if (user != null) {
                HttpSession session = request.getSession();
                AccountDAO accountDAO = new AccountDAO();

                if (accountDAO.login(user.getEmail(), "loginByGoogle") != null) {
                    Cookie usernameCookie = new Cookie("usernameCookie", user.getEmail());
                    response.addCookie(usernameCookie);
                    session.setAttribute("login", new Account(user.getEmail(), "loginByGoogle", accountDAO.login(user.getEmail(), "loginByGoogle").getRole()));
                } else {
                    accountDAO.register(new Account(user.getEmail(), "loginByGoogle", 0));
                    if (accountDAO.login(user.getEmail(), "loginByGoogle") == null) {
                        request.setAttribute("mess_er", "Login by google failed because email is registed , you can change pass to login");
                        request.getRequestDispatcher("./view/login.jsp").forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
             
            request.getRequestDispatcher("./view/login.jsp").forward(request, response);
        }
                  response.sendRedirect("home");

    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        AccountDAO accountDAO = new AccountDAO();
        if (accountDAO.login(username, password) != null) {
            Cookie usernameCookie = new Cookie("usernameCookie", username);
            response.addCookie(usernameCookie);
            session.setAttribute("login", new Account(username, password, accountDAO.login(username, password).getRole()));
            response.sendRedirect("home");
        } else {
            session.setAttribute("login", null);
            request.setAttribute("mess_er", "Login failed !!");
            request.getRequestDispatcher("./view/login.jsp").forward(request, response);
        }

    }

   
}
