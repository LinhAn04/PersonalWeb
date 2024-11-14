package Ch08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class EmailListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String url = "/Web/Ch08/Ch08View.jsp";

        // get current action
        String action = req.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/Web/Ch08/Ch08View.jsp";    // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            // store data in User object and save User object in db
            User user = new User(firstName, lastName, email);

            //Tạo session để lưu danh sách người dùng
            HttpSession session = req.getSession();
            List<User> users = (List<User>) session.getAttribute("users");
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(user);
            session.setAttribute("users", users);

            // set User object in request object and set URL
            req.setAttribute("user", user);
            url = "/Web/Ch08/Ch08Thanks.jsp";   // the "thanks" page
        }

        // Lấy ngày hiện tại
        GregorianCalendar currentDate = new GregorianCalendar();
        // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate.getTime());

        req.setAttribute("currentDate", formattedDate);

        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
}
