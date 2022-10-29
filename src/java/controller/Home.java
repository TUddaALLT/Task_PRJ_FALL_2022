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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author 84352
 */
public class Home extends BaseRequiredAuthentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
        HttpSession session = request.getSession();
        ArrayList<Task> listTasksNoti = taskDAO.getTasks(username);
        String time = "";
        String des = "";

        String t = taskDAO.getTaskSuccess(Utils.getAccountLogin(request).getUsername());

        String x[] = t.split(" ");

        ArrayList<Integer> dones = new ArrayList<>();
        dones.add(Integer.MAX_VALUE);
        for (String string : x) {
            if (!string.equals("")) {
                dones.add(Integer.parseInt(string));
            }
        }

        request.setAttribute("dones", dones);
        for (Task task : listTasksNoti) {
            time = time + " " + task.getTime_exc();
            des = des + "*" + task.getDescribe();

        }
        if (des.length() > 1) {
            des = des.substring(1);
        }

        session.setAttribute("des", des);
        session.setAttribute("time", time.trim());
        request.setAttribute("tasks", taskDAO.getTop2Tasks(username));
        request.getRequestDispatcher("./view/home.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
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
        HttpSession session = request.getSession();

        ArrayList<Task> listTasksNoti = taskDAO.getTasks(username);
        String time = "";
        String des = "";
        for (Task task : listTasksNoti) {
            time = time + " " + task.getTime_exc();
            des = des + "*" + task.getDescribe();
        }
        session.setAttribute("time", time);
        des = des.substring(1);
        session.setAttribute("des", des);
        int number;
        try {
            String raw_num = request.getParameter("ex");
            number = Integer.parseInt(raw_num);
        } catch (Exception e) {
            number = 1;
        }

        PrintWriter out = response.getWriter();

        ArrayList<Task> listTasks = taskDAO.getTop2NextTasks(username, number);
        ArrayList<Integer> dones = new ArrayList<>();
        try {
            String t = taskDAO.getTaskSuccess(Utils.getAccountLogin(request).getUsername());

            String x[] = t.split(" ");

            for (String string : x) {
                dones.add(Integer.parseInt(string));
            }

            request.setAttribute("dones", dones);
        } catch (Exception e) {
        }

        for (Task listTask : listTasks) {
            String status = "";
            switch (listTask.getStatus()) {
                case 1:
                    status = "<h5 class=\"card-title\" style=\"color: green ;font-weight: bold;\">\n"
                            + "                                        Status: On-going\n"
                            + "                                    </h5>";
                    break;
                case 2:
                    status = "<h5 class=\"card-title\" style=\"color: blue ; font-weight: bold;\">\n"
                            + "                                        Status: End\n"
                            + "                                    </h5> ";
                    break;
                default:
                    status = "<h5 class=\"card-title\" style=\"color: red;font-weight: bold;\">\n"
                            + "                                        Status: Start\n"
                            + "                                    </h5>";
                    break;
            }
            String task = "";
            String update = "";
            String delete = "";
            if (listTask.getGroupID() != 0) {
                task = "<h5>Task from: " + listTask.getUsername() + "<h5>";
            } else if (listTask.getGroupID() == 0) {
                task = "<h5>Your task<h5>";
            }
            if ((listTask.getGroupID() != 0) && !(listTask.getUsername().equals(username))) {
                update = "<span tabindex=\"0\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"You can not update\">   <a href=\"./updatetask\"  class=\"btn btn-primary disabled \"><i class=\"fa-solid fa-pen-nib\"></i></a> </span>";
                int isdone = 0;
                if (!dones.isEmpty()) {
                    for (Integer done : dones) {
                        if (done == listTask.getId()) {
                            update += "<span tabindex=\"0\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"Task have been completed\"> <a onclick=\"doneTask(this,'" + listTask.getId() + "','" + listTask.getGroupID() + "','" + listTask.getUsername() + "')\" class=\"btn btn-success done_task disabled \"><i class=\"fa-solid fa-check\"></i></a> </span>";
                            isdone = 1;
                            break;
                        }
                    }
                }
                if (isdone != 1) {
                    update += " <a onclick=\"doneTask(this,'" + listTask.getId() + "','" + listTask.getGroupID() + "','" + listTask.getUsername() + "')\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"Complete Task\" class=\"btn btn-success done_task  \"><i class=\"fa-solid fa-check\"></i></a>";
                }
                delete = " <span tabindex=\"0\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"You can not delete\"><a class=\"btn btn-danger disabled\">\n"
                        + "                                            <i onclick=\"deleteTask('${t.id}')\" class=\"fa-solid fa-trash \"></i> \n"
                        + "                                        </a> </span>\n";
            }
            if ((listTask.getGroupID() == 0) || (listTask.getUsername().equals(username))) {
                update = "   <a onclick=\"updateTask('" + listTask.getId() + "')\" data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"Update Task\" class=\"btn btn-primary   \"><i class=\"fa-solid fa-pen-nib\"></i></a>";
                delete = "<div data-bs-toggle=\"tooltip\" data-bs-placement=\"top\" title=\"Delete Task\" class=\"btn btn-danger \">\n"
                        + "<i onclick=\"deleteTask('" + listTask.getId() + "','" + listTask.getDescribe() + "')\" class=\"fa-solid fa-trash \"></i> \n"
                        + "                                        </div>"
                        + "\n";
            }
            out.println(" <div class=\"main animate__animated animate__backInUp \">\n"
                    + "                        <div class=\"content_task\" >\n"
                    + "                            <div style=\"  height: 25vh;  width: 10vw  \">"
                    + "<img src=\"files/" + listTask.getImg() + "\" class=\"card-img-top\" style=\"height: 100%;border-radius: 5px; min-width:154px; background-repeat: repeat-y;  object-fit: cover\"/>"
                    + ""
                    + "</div>\n"
                    + "                                <div class=\"card-body\">\n"
                    + status + task
                    + "                                <h5>Description: " + listTask.getDescribe() + "</h5>\n"
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
}
