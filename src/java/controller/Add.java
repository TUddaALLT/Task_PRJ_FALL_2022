/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaskDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import jakarta.servlet.annotation.MultipartConfig;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author 84352
 */
@MultipartConfig
public class Add extends BaseRequiredAuthentication {

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
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("groupID", 0);
        request.getRequestDispatcher("./view/addtask.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        save file anh
        Part part = request.getPart("img");
        String path = request.getServletContext().getRealPath("/files");
        String img = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String describe = request.getParameter("describe");
        if (!Files.exists(Paths.get(path))) {
            Files.createDirectory(Paths.get(path));
        }
        part.write(path + "/" + img);
        //   save file anh
        String raw_groupID = request.getParameter("groupID");
        String raw_status = request.getParameter("status");
        int   status, groupID;
        TaskDAO taskDAO = new TaskDAO();
        ArrayList<Task> tasks = taskDAO.getTasks(Utils.getAccountLogin(request).getUsername());
        try {
            groupID = Integer.parseInt(raw_groupID);
            status = Integer.parseInt(raw_status);
            Task t;
            t = new Task(img, describe, status, Utils.getAccountLogin(request).getUsername(), groupID);

            taskDAO.addTask(t);
            request.setAttribute("tasks", taskDAO.getTop2Tasks(Utils.getAccountLogin(request).getUsername()));
            request.getRequestDispatcher("./view/home.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
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
