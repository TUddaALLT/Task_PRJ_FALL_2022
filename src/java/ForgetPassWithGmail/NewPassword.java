package ForgetPassWithGmail;

import controller.Utils;
import dao.AccountDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

//    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confirm_password");

        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.changePassword((String) session.getAttribute("email"), Utils.enCodePassword(newPassword));
            request.setAttribute("mess", "Change successfully");
            request.getRequestDispatcher("./view/login.jsp").forward(request, response);
        } else {
            request.setAttribute("mess_er", "Password is not matched");
            request.getRequestDispatcher("./view/newPassword.jsp").forward(request, response);
        }
    }
}
