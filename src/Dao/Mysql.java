package Dao;

import java.sql.*;

public class Mysql {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/student?&useSSL=false";  //url中的status为数据库库名
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con = null;

    //获取连接
    public static Connection getConn() {
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取连接
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


    //关闭连接（有结果集）
    public static void closeConn(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭连接（无结果集）
    public static void closeConn(Connection conn, Statement stmt) {
        if (stmt != null) try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //测试连接数据库
    public static void main(String[] args) {
        System.out.print(getConn());
    }

}