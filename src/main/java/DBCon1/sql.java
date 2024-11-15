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
        // Kiểm tra xem tham số sqlStatement có tồn tại và không phải null
        String sqlStatement = req.getParameter("sqlStatement");
        if (sqlStatement == null) {
            sqlStatement = "select * from docgia";  // Nếu không có, gán giá trị mặc định
        }

        String sqlResult = "";
        try
        {
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
            // get a connection
            String dbURL = "jdbc:mysql://mysql-26a3e4b3-lehoanglinhan04-40e3.d.aivencloud.com:28833/jdbc_ch11";
            String username = "avnadmin";
            String password = "AVNS_OTp-IRMeLkE16zRhHEm";
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            // create a statement
            Statement statement = connection.createStatement();
            //parse the SQL string
            sqlStatement = sqlStatement.trim(); // Kiểm tra không phải null

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

        // Lưu kết quả vào session
        HttpSession session = req.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);

        // Chuyển trang
        String url = "/Web/DBCon1/JDBCView.jsp";
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
