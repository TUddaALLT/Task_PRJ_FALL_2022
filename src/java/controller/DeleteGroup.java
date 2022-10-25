/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountGroupDAO;
import dao.GroupTaskDAO;
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
public class DeleteGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        try {
            int id = Integer.parseInt(raw_id);
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            accountGroupDAO.deleteById(id);
            TaskDAO taskDAO = new TaskDAO();
            taskDAO.deleteTaskById(id);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            groupTaskDAO.deleteGroupTask(id);
            
            // notification
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String time_maked = dateFormat.format(date);
            model.Notification notification = new model.Notification("You have deleted group " + id,
                    Utils.getAccountLogin(request).getUsername(), "Deleted group", time_maked);
            NotificationDAO notificationDAO = new NotificationDAO();
            notificationDAO.addNotification(notification);
            
            response.sendRedirect("groupcreated");
            
            
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
