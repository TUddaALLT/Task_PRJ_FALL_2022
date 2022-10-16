/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author 84352
 */
public class SearchTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskDAO taskDAO = new TaskDAO();
        String username = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("usernameCookie")) {
                    username = cooky.getValue();
                }
            }
        }
        String describe = request.getParameter("describe");
        int  status = Integer.parseInt(request.getParameter("status"));
        if (describe.equals("") && status == 0) {
            request.setAttribute("tasks", taskDAO.getTop2Tasks(username));
            request.getRequestDispatcher("./view/home.jsp").forward(request, response);
        }

        ArrayList<Task> listTasks = taskDAO.searchTasks(describe,  status, username);
        request.setAttribute("tasks", listTasks);
        request.setAttribute("search", "search");
        request.getRequestDispatcher("./view/home.jsp").forward(request, response);
    }

}
