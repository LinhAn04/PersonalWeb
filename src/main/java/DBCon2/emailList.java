package DBCon2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class emailList extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        String url = "/Web/DBCon2/JDBC2View.jsp";
//        String message = " ";
//
//        String action = req.getParameter("action");
//        if (action == null) {
//            action = "join";
//        }
//        if (action.equals("join")) {
//            url = "/Web/DBCon2/JDBC2View.jsp";
//        }
//        else if (action.equals("add")) {
//            String firstName = req.getParameter("firstName");
//            String lastName = req.getParameter("lastName");
//            String email = req.getParameter("email");
//
//            User user = new User(firstName, lastName, email);
//
//            if(UserDB.emailExists(user.getEmail())){
//                message = "This email address already exists.<br>" +
//                        "Please enter another email address.";
//                url = "/Web/DBCon2/JDBC2View.jsp";
//            }
//            else{
//                message = " ";
//                url = "/Web/DBCon2/JDBC2Thanks.jsp";
//                UserDB.insert(user);
//            }
//            req.setAttribute("user",user);
//            req.setAttribute("message",message);
//        }
//        //Chuyển trang
//        RequestDispatcher dispatcher =
//                req.getRequestDispatcher(url);
//        dispatcher.forward(req, res);
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        doPost(req, res);
//    }
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    String url = "/Web/DBCon2/JDBC2View.jsp";
    String message = " ";

    String action = req.getParameter("action");
    if (action == null) {
        action = "join";
    }

    if (action.equals("join")) {
        url = "/Web/DBCon2/JDBC2View.jsp";
    } else if (action.equals("add")) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        User user = new User(firstName, lastName, email);

        // Kiểm tra xem email đã tồn tại chưa
        if (UserDB.emailExists(user.getEmail())) {
            message = "This email address already exists.<br>" +
                    "Please enter another email address.";
            url = "/Web/DBCon2/JDBC2View.jsp";
        } else {
            message = " ";
            url = "/Web/DBCon2/JDBC2Thanks.jsp";
            UserDB.insert(user);  // Thêm user vào cơ sở dữ liệu
        }

        req.setAttribute("user", user);
        req.setAttribute("message", message);
    }

    // Chuyển trang
    RequestDispatcher dispatcher = req.getRequestDispatcher(url);
    dispatcher.forward(req, res);
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
