package Dao;

import studentmanage.Student;

import java.sql.*;
import java.util.*;

public class studentDao {

    //添加学生信息
    public void add(Student Student) {
        //需要连接数据库，使用sql语句进行添加
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "insert into student_info(id, name, sex, academy, major, grade, classes) values(?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Student.getId());
            stmt.setString(2, Student.getName());
            stmt.setString(3, Student.getSex());
            stmt.setString(4, Student.getAcademy());
            stmt.setString(5, Student.getMajor());
            stmt.setString(6, Student.getGrade());
            stmt.setInt(7, Student.getClasses());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("添加成功！");
    }

    /**
     * 修改学生信息
     * 连接数据库，foreach进行sql语句替换
     */
    //修改学生姓名
    public void changeName(Integer changeId, String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set name = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("姓名修改成功!!");
    }

    //修改学生性别
    public void changeSex(Integer changeId, String sex) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set sex = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sex);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("性别修改成功!!");
    }

    //修改学生学院
    public void changeAcademy(Integer changeId, String academy) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set academy = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, academy);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("学院修改成功!!");
    }

    //修改学生专业
    public void changeMajor(Integer changeId, String major) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set major = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, major);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("专业修改成功!!");
    }

    //修改学生年级
    public void changeGrade(Integer changeId, String grade) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set grade = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, grade);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("年级修改成功!!");
    }

    //修改学生班级
    public void changeClasses(Integer changeId, String classes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "update student_info set classes = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, classes);
            stmt.setInt(2, changeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("班级修改成功!!");
    }

    //删除学生信息
    public void delete(Integer deleteId) {
        //连接数据库，sql语句删除
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Mysql.getConn();
            String sql = "delete from student_info where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, deleteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        System.out.println("删除成功!!");
    }

    //数据库操作
    public List<Student> getAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<>();

        try {
            conn = Mysql.getConn();
            String sql = "select * from student_info";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String academy = rs.getString("academy");
                String major = rs.getString("major");
                String grade = rs.getString("grade");
                Integer classes = rs.getInt("classes");

                Student Student = new Student(id, name, sex, academy, major, grade, classes);

                stuList.add(Student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt, rs);
        }
        return stuList;
    }

    //判断id是否存在
    public boolean judgeExist(Integer stuId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = Mysql.getConn();
            String sql = "select count(*) as count from student_info where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, stuId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt, rs);
        }
        if (count == 0) return false;
        else
            return true;
    }


    //数据库查找
    public Student find(Integer findId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Student Student = null;
        try {
            conn = Mysql.getConn();
            String sql = "select * from student_info where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, findId);
            ResultSet tmpres = stmt.executeQuery();
            Student = new Student();
            while (tmpres.next()) {
                Student.setId(tmpres.getInt("id"));
                Student.setName(tmpres.getString("name"));
                Student.setSex(tmpres.getString("sex"));
                Student.setAcademy(tmpres.getString("academy"));
                Student.setMajor(tmpres.getString("major"));
                Student.setGrade(tmpres.getString("grade"));
                Student.setClasses(tmpres.getInt("classes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Mysql.closeConn(conn, stmt);
        }
        return Student;
    }


}