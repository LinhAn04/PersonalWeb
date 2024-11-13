package Survey.surveyform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Survey.business.User;

import java.io.IOException;

//@WebServlet(urlPatterns = { "/emailList" })
public class SurveyList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/Web/Survey/surveyView.jsp";

        // get current action
        String action = req.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/Web/Survey/surveyView.jsp";    // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String FirstName = req.getParameter("FirstName");
            String LastName = req.getParameter("LastName");
            String Email = req.getParameter("Email");
            String DateOfBirth = req.getParameter("DateOfBirth");
            String HearInfor = req.getParameter("Tools");
            //<input type="radio" id="SearchEngine" name="Tools" value="Search engine">

            String tbao = null;
            String[] ReceiveInfor = req.getParameterValues("option");
            if(ReceiveInfor != null)
            {
                tbao = String.join(",", ReceiveInfor);
            }
            String Contact = req.getParameter("contacts");

            // store data in User object and save User object in db
            User user = new User(FirstName, LastName, Email, DateOfBirth, HearInfor, tbao, Contact);
            // UserDB.insert(user);

            // set User object in request object and set URL
            req.setAttribute("user", user);
            url = "/Web/Survey/surveyInfor.jsp";   // the "thanks" page
        }

        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
}
