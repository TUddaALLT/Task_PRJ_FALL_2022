/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller_group;

import controller.Utils;
import dao.AccountGroupDAO;
import dao.GroupTaskDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
            HttpSession httpSession = request.getSession();
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            ArrayList<GroupTask> list = groupTaskDAO.getAllGroupTaskByUserName(Utils.getAccountLogin(request).getUsername());

            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            int checkmygr = 0;
            for (int i = 0; i < list.size(); i++) {
                String la[] = accountGroupDAO.getAccGr(list.get(i).getGroupID()).split(" ");
                for (int j = 0; j < la.length; j++) {
                    String string = la[j].trim();
                    if (string.equals(Utils.getAccountLogin(request).getUsername())) {
                        checkmygr = 1;
                        break;
                    }
                }
                if (checkmygr == 0) {
                    list.remove(i);
                } else {
                    list.get(i).setUsernames(la);
                }
                checkmygr = 0;
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
