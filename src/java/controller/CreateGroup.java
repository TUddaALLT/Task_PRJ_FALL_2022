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
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateGroup</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateGroup at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Account account =(Account) httpSession.getAttribute("login");
        if(account!=null&&account.getRole()==1){
            request.getRequestDispatcher("./view/creategroup.jsp").forward(request, response);
            request.setAttribute("messToUpgrade", null);
        }else{
            request.setAttribute("messToUpgrade", "You must upgrade to create group");
            request.getRequestDispatcher("./view/creategroup.jsp").forward(request, response);
        }
       
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String raw_id = request.getParameter("id");
        String nameGroup = request.getParameter("namegroup");
        HttpSession httpSession = request.getSession();
        Account accountm= (Account) httpSession.getAttribute("login");
        int id ;
        try {
            id = Integer.parseInt(raw_id);
            GroupTask groupTask = new GroupTask(id, accountm.getUsername() , nameGroup);
            GroupTaskDAO groupTaskDAO = new GroupTaskDAO();
            groupTaskDAO.addGroupTask(groupTask);
            response.sendRedirect("groupcreated");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
