/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.NotificationDAO;
import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 84352
 */
public class Notification extends HttpServlet {

    static int num = 100;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        NotificationDAO notificationDAO = new NotificationDAO();
        if (num < notificationDAO.countNotification(Utils.getAccountLogin(request).getUsername())) {
            String notification = notificationDAO.getNotification(Utils.getAccountLogin(request).getUsername());
            out.println(notification);
        }else{
            out.println("error");
        }
        num = notificationDAO.countNotification(Utils.getAccountLogin(request).getUsername());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
