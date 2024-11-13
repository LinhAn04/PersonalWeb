package Ch05.ex1;

import Ch05.User.Ch05User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Ch05ex1Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/Web/Ch05ex1/Ch05ex1View.jsp";
        //Lấy giá trị action hiện tại và gán bằng giá trị mặc định
        String action = req.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/Web/Ch05ex1/Ch05ex1View.jsp";
        }
        else if (action.equals("add")) {
            // Lấy tham số từ request
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            //Lưu lại dữ liệu
            Ch05User user = new Ch05User(firstName, lastName, email);
            //Tạo đối tượng cho user
            req.setAttribute("user", user);
            url = "/Web/Ch05ex1/Ch05ex1Thanks.jsp";   // the "thanks" page
        }
        //Chuyển trang
        RequestDispatcher dispatcher =
                this.getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
