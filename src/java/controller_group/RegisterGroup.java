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
import jakarta.servlet.http.HttpSession;
import java.security.acl.Group;
import model.Account;
import model.GroupTask;

/**
 *
 * @author 84352
 */
public class RegisterGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Account account = (Account) httpSession.getAttribute("login");
        if (account != null) {
            request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("./view/mustlogin.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int idGroup;

        try {
            idGroup = Integer.parseInt(raw_id);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            if (groupTaskDAO.getGroupTask(idGroup) == null) {
                request.setAttribute("mess", "Group ID is not existed");
                request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
            }
            for (GroupTask groupTask : groupTaskDAO.getAllGroupTask()) {
                if (groupTask.getGroupOfusername().equals(Utils.getAccountLogin(request).getUsername())) {
                    request.setAttribute("mes", "Group is your group");
                    request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
                }
            }
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            accountGroupDAO.addAccountGroup(idGroup, Utils.getAccountLogin(request).getUsername());
            Utils.notification(request, "You have registed group " + idGroup, "Register group");
            response.sendRedirect("mygroup");

        } catch (Exception e) {
            request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
        }
    }

}
