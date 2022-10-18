/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountGroupDAO;
import dao.GroupTaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.GroupTask;

/**
 *
 * @author 84352
 */
public class MyGroup extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            ArrayList<GroupTask> list = groupTaskDAO.getAllGroupTaskByUserName(Utils.getAccountLogin(request).getUsername());
            
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            for (int i = 0; i < list.size(); i++) {
                String la[] = accountGroupDAO.getAccGr(list.get(i).getGroupID()).split(" ");
                 list.get(i).setUsernames(la);
            }
            request.setAttribute("list", list);
            if (groupTaskDAO.getAllGroupTaskByUserName(Utils.getAccountLogin(request).getUsername()).isEmpty()) {
                request.setAttribute("mess", "You do not have any group");
            } else {
                request.setAttribute("mess", null);
            }
            request.getRequestDispatcher("./view/mygroup.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("./view/mygroup.jsp").forward(request, response);
//            request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
