/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GroupTaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.GroupTask;

/**
 *
 * @author 84352
 */
public class CreateGroup extends HttpServlet {

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (Utils.getAccountLogin(request) == null) {
            request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
        }
        if (Utils.getAccountLogin(request) != null && Utils.getAccountLogin(request).getRole() == 1) {
            request.getRequestDispatcher("./view/creategroup.jsp").forward(request, response);
            request.setAttribute("messToUpgrade", null);
        } else {
            request.setAttribute("messToUpgrade", "You must upgrade to create group");
            request.getRequestDispatcher("./view/creategroup.jsp").forward(request, response);
        }

    }

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String raw_id = request.getParameter("id");
        String nameGroup = request.getParameter("namegroup");
//        HttpSession httpSession = request.getSession();
//        Account accountm = (Account) httpSession.getAttribute("login");
        int id;
        try {
//            id = Integer.parseInt(raw_id);
            GroupTask groupTask = new GroupTask(Utils.getAccountLogin(request).getUsername(), nameGroup);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            groupTaskDAO.addGroupTask(groupTask);
             Utils.notification(request, "You have create group " + nameGroup , "Create group");
            response.sendRedirect("groupcreated");
           
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

   
}
