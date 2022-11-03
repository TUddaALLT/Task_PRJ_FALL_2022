/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller_group;

import controller.Utils;
import dao.AccountGroupDAO;
import dao.TaskDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author 84352
 */
public class TaskInGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskDAO taskDAO = new TaskDAO();
        int groupID = Integer.parseInt(request.getParameter("groupID"));
        ArrayList<Task> allTasks = taskDAO.getTasks(Utils.getAccountLogin(request).getUsername());
        ArrayList<Task> allTasksInGroup = new ArrayList<>();
        for (Task task : allTasks) {
            if (task.getGroupID() == groupID) {
                allTasksInGroup.add(task);
            }
        }
        if (allTasksInGroup.isEmpty()) {
            request.setAttribute("not_ass", "check");
        }
        AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
        request.setAttribute("groupID", groupID);
        ArrayList<model.TaskSuccess> taskSuccesses = taskDAO.getUsernameDoneTask(Utils.getAccountLogin(request).getUsername(), groupID);
        request.setAttribute("taskSuccesses", taskSuccesses);
        request.setAttribute("usernameCompleted", accountGroupDAO.getAccGr(groupID).split(" "));
        request.setAttribute("allTasksInGroup", allTasksInGroup);
        System.out.println("");
        request.getRequestDispatcher("./view/taskingroup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
