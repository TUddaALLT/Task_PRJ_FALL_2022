/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author 84352
 */
public class TaskExpired extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        TaskDAO taskDAO = new TaskDAO();
        ArrayList<Task> listTasksNoti = taskDAO.getTasks(Utils.getAccountLogin(request).getUsername());
        String time = "";
        String des = "";
        for (Task task : listTasksNoti) {
            time = time + " " + task.getTime_exc();
            des = des + "*" + task.getDescribe();
        }
        des = des.substring(1);
        HttpSession session = request.getSession();
        session.setAttribute("expired", time + "+^" + des);
        out.println(time + "+^" + des);
//        session.setAttribute("time", time);
//        des = des.substring(1);
//        session.setAttribute("des", des);
    }

}
