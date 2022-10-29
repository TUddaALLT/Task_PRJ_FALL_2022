/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GroupTaskDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 84352
 */
public class GroupCreated extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            request.setAttribute("list", groupTaskDAO.getAllCreatedGroupTaskByUsername(Utils.getAccountLogin(request).getUsername()));
            if (groupTaskDAO.getAllCreatedGroupTaskByUsername(Utils.getAccountLogin(request).getUsername()).isEmpty()) {
                request.setAttribute("mess", "You do not create group");
            } else {
                request.setAttribute("mess", null);
            }
        } catch (Exception e) {
           request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
        }

        request.getRequestDispatcher("./view/groupcreated.jsp").forward(request, response);

    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    } 
}
