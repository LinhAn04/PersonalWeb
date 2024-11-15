package DBCon2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
//    public static int insert(User user){
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query
//                = "INSERT INTO user(email, firstName, lastName) "
//                + "VALUES(?, ?, ?)";
//        try{
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getEmail());
//            ps.setString(2,user.getFirstName());
//            ps.setString(3, user.getLastName());
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//
//    public static int update(User user) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "UPDATE user SET "
//                + "firstName = ?, "
//                + "lastName = ? "
//                + "WHERE email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getFirstName());
//            ps.setString(2, user.getLastName());
//            ps.setString(3, user.getEmail());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//    public static int delete(User user) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "DELETE FROM user "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getEmail());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//
//    public static boolean emailExists(String email) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT Email FROM user "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, email);
//            rs = ps.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return false;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//    public static User selectUser(String email) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM User "
//                + "WHERE Email = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, email);
//            rs = ps.executeQuery();
//            User user = null;
//            if (rs.next()) {
//                user = new User();
//                user.setFirstName(rs.getString("firstName"));
//                user.setLastName(rs.getString("lastName"));
//                user.setEmail(rs.getString("email"));
//            }
//            return user;
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
public static boolean emailExists(String email) {
    Connection conn = ConnectionPool.getInstance().getConnection();
    if (conn == null) {
        System.out.println("Failed to get connection for email check.");
        return false;  // Nếu không có kết nối, trả về false
    }

    try {
        String sql = "SELECT email FROM Users WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        boolean exists = rs.next();  // Nếu có email trong database, trả về true
        DBUtil.closeResultSet(rs);
        DBUtil.closePreparedStatement(stmt);
        return exists;
    } catch (SQLException e) {
        System.out.println("SQL Error in emailExists: " + e.getMessage());
        e.printStackTrace();
    } finally {
        ConnectionPool.getInstance().freeConnection(conn); // Giải phóng kết nối
    }

    return false;
}

    // Thêm phương thức insert vào database (nếu cần)
    public static void insert(User user) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        if (conn == null) {
            System.out.println("Failed to get connection for insert.");
            return;
        }

        try {
            String sql = "INSERT INTO Users (firstName, lastName, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Error in insert: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().freeConnection(conn);  // Giải phóng kết nối
        }
    }
}
