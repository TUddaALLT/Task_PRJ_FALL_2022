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
public class Home extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    
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
        request.setAttribute("tasks", taskDAO.getTop2Tasks(username));       
        request.getRequestDispatcher("./view/home.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        int number;
        try {
            String raw_num = request.getParameter("ex");
            number = Integer.parseInt(raw_num);
        } catch (Exception e) {
            number = 1;
        }

        PrintWriter out = response.getWriter();

        ArrayList<Task> listTasks = taskDAO.getTop2NextTasks(username, number);
        for (Task listTask : listTasks) {
            String status = "";
            if (listTask.getStatus() == 1) {
                status = "<h5 class=\"card-title\" style=\"color: green ;font-weight: bold;\">\n"
                        + "                                        Status: On-going\n"
                        + "                                    </h5>";
            } else if (listTask.getStatus() == 2) {
                status = "<h5 class=\"card-title\" style=\"color: blue ; font-weight: bold;\">\n"
                        + "                                        Status: End\n"
                        + "                                    </h5> ";
            } else {
                status = "<h5 class=\"card-title\" style=\"color: red;font-weight: bold;\">\n"
                        + "                                        Status: Start\n"
                        + "                                    </h5>";
            }
            String task = "";
            String update = "";
            String delete = "";
            if (listTask.getGroupID() != 0) {
                task = "<p>Task from: " + listTask.getUsername() + "<p>";
            } else if (listTask.getGroupID() == 0) {
                task = "<p>Your task<p>";
            }
            if ((listTask.getGroupID() != 0) && !(listTask.getUsername().equals(username))) {
                update = "   <a href=\"./updatetask\" class=\"btn btn-primary disabled \">Update Task</a>";
                delete = "<div class=\"btn btn-primary disabled\">\n"
                        + "                                            <i onclick=\"deleteTask('${t.id}')\" class=\"fa-solid fa-trash \"></i> \n"
                        + "                                        </div>\n";
            }
            if ((listTask.getGroupID() == 0) || (listTask.getUsername().equals(username))) {
                update = "   <a href=\"./updatetask\" class=\"btn btn-primary   \">Update Task</a>";
                delete = "<div class=\"btn btn-primary \">\n"
                        + "<i onclick=\"deleteTask('" + listTask.getId() + "')\" class=\"fa-solid fa-trash \"></i> \n"
                        + "                                        </div>\n";
            }
            out.println(" <div class=\"main\">\n"
                    + "                        <div class=\"card\" >\n" +
 
                   "                            <div>"
                    + "<img src=\"files/" + listTask.getImg() + "\" class=\"card-img-top\" style=\"height: 100%;  object-fit: cover\"/>"
                    + ""
                    + "</div>\n"
                    + "                                <div class=\"card-body\">\n"
                    + status + task
                    + "                                <p>Description: " + listTask.getDescribe() + "</p>\n"
                    + "                                <div class=\"trash\">\n"
                    + "\n"
                    + update + delete
                    + "\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </div>"
            );
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
