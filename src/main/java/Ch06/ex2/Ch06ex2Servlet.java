package Ch06.ex2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Ch06ex2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/Web/Ch06ex2/Ch06ex2View.jsp";
        //Lấy giá trị action hiện tại và gán bằng giá trị mặc định
        String action = req.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/Web/Ch06ex2/Ch06ex2View.jsp";
        }
        else if (action.equals("add")) {
            // Lấy tham số từ request
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String heardfrom = req.getParameter("heardfrom");
            String update = req.getParameter("Update");
            String contactvia = req.getParameter("contactvia");

            System.out.println( heardfrom + " " + update + " " + contactvia);

            //Lưu lại dữ liệu
            EmailUserCh06ex2 user =
                    new EmailUserCh06ex2(firstName, lastName, email,
                            heardfrom, update, contactvia);
            //Tạo đối tượng cho user
            req.setAttribute("user", user);

            url = "/Web/Ch06ex2/Ch06ex2Thanks.jsp";   // the "thanks" page
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
