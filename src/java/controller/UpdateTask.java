/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 *
 * @author 84352
 */
@MultipartConfig
public class UpdateTask extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        TaskDAO taskDAO = new TaskDAO();
        ArrayList<Task> tasks = taskDAO.getTasks(Utils.getAccountLogin(request).getUsername());
        for (Task task : tasks) {
            if (task.getId() == id) {
                request.setAttribute("task", task);
                break;
            }
        }
        request.getRequestDispatcher("./view/updatetask.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        save file anh
        Part part = request.getPart("img");
        String path = request.getServletContext().getRealPath("/files");
        String img = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        if (!Files.exists(Paths.get(path))) {
            Files.createDirectory(Paths.get(path));
        }
        part.write(path + "/" + img);
        //   save file anh
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        String raw_groupID = request.getParameter("groupID");
        String raw_status = request.getParameter("status");

        String time = request.getParameter("alarmTime");
        int status, groupID;
        String describe = request.getParameter("describe");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time_maked = dateFormat.format(date).toString();

        TaskDAO taskDAO = new TaskDAO();

        try {
            groupID = Integer.parseInt(raw_groupID);
            status = Integer.parseInt(raw_status);
            Task t;
            t = new Task(id, describe, status, groupID, time_maked, time, img);
            taskDAO.updateTask(t);
            request.setAttribute("tasks", taskDAO.getTop2Tasks(Utils.getAccountLogin(request).getUsername()));
            request.getRequestDispatcher("./view/home.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
