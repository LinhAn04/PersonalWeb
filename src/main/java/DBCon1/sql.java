package DBCon1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

public class sql extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String sqlStatement = req.getParameter("sqlStatement");

        String sqlResult = "";
        try
        {
            //load driver
            Class.forName("com.mysql.jdbc.Driver");
            //get a connection
            String dbURL = "jdbc:mysql://localhost:3306/JDBC_Ch11";
            String username = "root";
            String password = "01102004";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            //create a statement
            Statement statement = connection.createStatement();
            //parse the SQL string
            sqlStatement = sqlStatement.trim();

            if(sqlStatement.length() >= 6)
            {
                String sqlType = sqlStatement.substring(0, 6);

                if(sqlType.equalsIgnoreCase("select"))
                {
                    //create the HTML for the result set
                    ResultSet resultSet =
                            statement.executeQuery(sqlStatement);
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                }
                else
                {
                    int i = statement.executeUpdate(sqlStatement);
                    if(i == 0)
                    {
                        sqlResult = "<p>The statement executed successfully.</p>";
                    }
                    else
                    {
                        sqlResult = "<p>The statement executed successfully.<br>"
                                + i + "row(s) affected.</p>";
                    }
                }
            }
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException e)
        {
            sqlResult = "<p>Error loading the database driver: <br>"
                    + e.getMessage() + "</p>";
        }
        catch (SQLException e)
        {
            sqlResult = "<p>Error executing the SQL statement:<br>"
                    + e.getMessage() + "</p>";
        }
        HttpSession session = req.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);

        String url = "/Web/DBCon1/JDBCView.jsp";

        //Chuyển trang
        RequestDispatcher dispatcher =
                req.getRequestDispatcher(url);
        dispatcher.forward(req, res);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
