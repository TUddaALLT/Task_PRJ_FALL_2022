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
import model.GroupTask;

/**
 *
 * @author 84352
 */
public class OutGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int idGroup;
        try {
            idGroup = Integer.parseInt(raw_id);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            accountGroupDAO.outAccountGroup(idGroup, Utils.getAccountLogin(request).getUsername());
            Utils.notification(request, "You have out group " + idGroup , "Out group");
            response.sendRedirect("mygroup");
        } catch (Exception e) {
            request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
