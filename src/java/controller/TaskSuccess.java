/*
 * Click nbfs=//nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs=//nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GroupTaskDAO;
import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 84352
 */
public class TaskSuccess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int groupID = Integer.parseInt(request.getParameter("groupID"));
            String usernameMake = request.getParameter("usernameMake");
            TaskDAO taskDAO = new TaskDAO();
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            taskDAO.addTaskSuccess(id, groupID, usernameMake, Utils.getAccountLogin(request).getUsername());
            
            
            System.out.println("");
        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
