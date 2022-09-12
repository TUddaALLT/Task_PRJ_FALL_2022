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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterGroup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterGroup at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int idGroup;
        HttpSession httpSession = request.getSession();
        Account account = (Account) httpSession.getAttribute("login");
        try {
            idGroup = Integer.parseInt(raw_id);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            if (groupTaskDAO.getGroupTask(idGroup) == null) {
                request.setAttribute("mess", "Group ID is not existed");
                request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
            }
            for (GroupTask groupTask : groupTaskDAO.getAllGroupTask()) {
                if (groupTask.getGroupOfusername().equals(account.getUsername())) {
                    request.setAttribute("mes", "Group is your group");
                    request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
                }
            }
            AccountGroupDAO accountGroupDAO = new AccountGroupDAO();
            accountGroupDAO.addAccountGroup(idGroup, account.getUsername());
            response.sendRedirect("home");

        } catch (Exception e) {
             request.getRequestDispatcher("./view/registergroup.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
