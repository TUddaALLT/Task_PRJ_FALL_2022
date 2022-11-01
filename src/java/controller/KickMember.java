/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountGroupDAO;
import dao.GroupTaskDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author 84352
 */
public class KickMember extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String username = request.getParameter("username");
        int idGroup;
        try {
            idGroup = Integer.parseInt(raw_id);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            accountGroupDAO.outAccountGroup(idGroup, username);
            Utils.notification(request, "Kick " + username, " group" + idGroup);
            PrintWriter out = response.getWriter();
            out.println("<script>window.location.href = \"taskingroup?groupID=" + idGroup + "\"\n</script>>");

        } catch (Exception e) {
            request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
