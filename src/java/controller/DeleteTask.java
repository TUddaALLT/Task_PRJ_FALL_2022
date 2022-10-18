/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.NotificationDAO;
import dao.TaskDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 84352
 */
public class DeleteTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String des = request.getParameter("describe");
        int id;
        try {
            id = Integer.parseInt(raw_id);
            TaskDAO taskDAO = new TaskDAO();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String time_maked = dateFormat.format(date).toString();
            model.Notification notification = new model.Notification("You have deleted task " + id,
                    Utils.getAccountLogin(request).getUsername(), "Delete Task", time_maked);
            NotificationDAO notificationDAO = new NotificationDAO();
            notificationDAO.addNotification(notification);

            taskDAO.deleteTask(id);
            response.sendRedirect("home");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
