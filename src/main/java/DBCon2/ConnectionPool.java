package DBCon2;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
//    private static ConnectionPool pool = null;
//    private static DataSource dataSource =  null;
//
//    private ConnectionPool() {
//        try{
//            InitialContext ic = new InitialContext();
//            dataSource = (DataSource)
//                    ic.lookup("java:/comp/env/jdbc/jdbc_ch11");
//        } catch (NamingException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static synchronized ConnectionPool getInstance() {
//        if (pool == null) {
//            pool = new ConnectionPool();
//        }
//        return pool;
//    }
//
//    public Connection getConnection() {
//        try{
//            return dataSource.getConnection();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        }
//    }
//
//    public void freeConnection(Connection conn) {
//        try{
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/jdbc_ch11"); // Định danh tên DataSource từ context.xml
        } catch (NamingException e) {
            System.out.println("Error initializing DataSource: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        if (dataSource == null) {
            System.out.println("DataSource is not initialized.");
            return null;  // Nếu dataSource là null, trả về null
        }
        try {
            Connection conn = dataSource.getConnection();
            if (conn == null) {
                System.out.println("Failed to get connection from DataSource.");
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Error obtaining connection: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
