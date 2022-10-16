/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 84352
 */
public abstract class BaseRequiredAuthentication extends HttpServlet {

    protected boolean isAuthenticated(HttpServletRequest request) {
        for (Cookie cooky : request.getCookies()) {
            if(cooky.getName().equals("usernameCookie")){
                return true;
            }
        }
        return (request.getSession().getAttribute("login") != null) ;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request)){
            processGet(request, response);
        }else{
            request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(isAuthenticated(request)){
            processPost(request, response);
       }else{
            request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
       }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    
}
