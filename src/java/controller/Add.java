/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import jakarta.servlet.annotation.MultipartConfig;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Task;

/**
 *
 * @author 84352
 */
@MultipartConfig
public class Add extends BaseRequiredAuthentication {
  
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("groupID", 0);
        request.getRequestDispatcher("./view/addtask.jsp").forward(request, response);
    } 
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        save file anh
        Part part = request.getPart("img");
        String path = request.getServletContext().getRealPath("/files");
        String img = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String describe = request.getParameter("describe");
        if (!Files.exists(Paths.get(path))) {
            Files.createDirectory(Paths.get(path));
        }
        part.write(path + "/" + img);
        //   save file anh
        String raw_groupID = request.getParameter("groupID");
        String raw_status = request.getParameter("status");

        String raw_time = request.getParameter("time");
        int time;
        int status, groupID;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(); 
        String time_maked = dateFormat.format(date).toString();
      
        TaskDAO taskDAO = new TaskDAO();

        try {
            groupID = Integer.parseInt(raw_groupID);
            status = Integer.parseInt(raw_status);
            time = Integer.parseInt(raw_time);

            Task t;
            t = new Task(img, describe, status, Utils.getAccountLogin(request).getUsername(), groupID, time_maked, time);

            taskDAO.addTask(t);
            request.setAttribute("tasks", taskDAO.getTop2Tasks(Utils.getAccountLogin(request).getUsername()));
            request.getRequestDispatcher("./view/home.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
 

}
