package studentmanage;

import Dao.studentDao;

import java.util.List;
import java.util.Scanner;

public class studentManager {

    Scanner sc = new Scanner(System.in);

    public void Manage(int choice) throws Exception {
        switch (choice) {
            case 0 -> list();
            case 1 -> find();
            case 2 -> add();
            case 3 -> change();
            case 4 -> delete();
            default -> throw new Exception("没有该功能，请重新选择！");
        }
    }

    //获取所有学籍信息
    public void list() {

        //查找数据库里的数据
        studentDao dao = new studentDao();
        List<Student> list = dao.getAll();
        System.out.println("学生信息列表如下：");
        for (Student Student : list) {
            System.out.println("学号：" + Student.getId() + " 姓名：" + Student.getName() + " 性别：" + Student.getSex() + " 学院：" + Student.getAcademy() + " 专业：" + Student.getMajor() + " 年级：" + Student.getGrade() + " 班级：" + Student.getClasses());
        }
    }
    //查询学生信息
    public void find() {
        System.out.println("请输入学生学号id：");
        Integer findId = Integer.valueOf(sc.next());
        studentDao dao = new studentDao();
        if (!dao.judgeExist(findId))
            System.out.println("该学生不存在！");
        else {
            Student Student = dao.find(findId);
            System.out.println("学号：" + Student.getId() + " 姓名：" + Student.getName() + " 性别：" + Student.getSex() + " 学院：" + Student.getAcademy() + " 专业：" + Student.getMajor() + " 年级：" + Student.getGrade() + " 班级：" + Student.getClasses());
        }
    }

    //添加学生信息
    public void add() {
        studentDao dao = new studentDao();
        System.out.println("请输入要添加的学生学号id：");
        Integer addId = Integer.valueOf(sc.next());
        if (dao.judgeExist(addId))
            System.out.println("该学生已存在！");
        else {
            System.out.println("输入姓名：");
            String name = sc.next();
            System.out.println("输入性别：");
            String sex = sc.next();
            System.out.println("输入学院：");
            String academy = sc.next();
            System.out.println("输入专业：");
            String major = sc.next();
            System.out.println("输入年级：");
            String grade = sc.next();
            System.out.println("输入班级：");
            Integer classes = Integer.valueOf(sc.next());
            dao.add(new Student(addId, name, sex, academy, major, grade, classes));
            System.out.println("查询到如下信息：");
            list();
        }
    }

    //修改学生信息
    public void change(){
        studentDao dao = new studentDao();
        System.out.println("请输入要修改的学生学号id：");
        Integer changeId = Integer.valueOf(sc.next());
        if (!dao.judgeExist(changeId))
            System.out.println("该学生不存在！");
        else {
            Student Student = dao.find(changeId);
            System.out.println("学号：" + Student.getId() + " 姓名：" + Student.getName() + " 性别：" + Student.getSex() + " 学院：" + Student.getAcademy() + "专业：" + Student.getMajor() + "年级：" + Student.getGrade() + "班级：" + Student.getClasses());
            System.out.println("请输入需要修改学生的信息:");
            System.out.println("1、姓名");
            System.out.println("2、性别");
            System.out.println("3、学院");
            System.out.println("4、专业");
            System.out.println("5、年级");
            System.out.println("6、班级");
            int changeChoice;
            changeChoice = Integer.parseInt(sc.next());
            switch (changeChoice) {
                case 1 -> {
                    System.out.println("请输入修改后的姓名：");
                    String name = sc.next();
                    dao.changeName(changeId, name);
                }
                case 2 -> {
                    System.out.println("请输入修改后的性别：");
                    String sex = sc.next();
                    dao.changeSex(changeId, sex);
                }
                case 3 -> {
                    System.out.println("请输入修改后的学院：");
                    String academy = sc.next();
                    dao.changeAcademy(changeId, academy);
                }
                case 4 -> {
                    System.out.println("请输入修改后的专业：");
                    String major = sc.next();
                    dao.changeMajor(changeId, major);
                }
                case 5 -> {
                    System.out.println("请输入修改后的年级：");
                    String grade = sc.next();
                    dao.changeGrade(changeId, grade);
                }
                case 6 -> {
                    System.out.println("请输入修改后的班级：");
                    String classes = sc.next();
                    dao.changeClasses(changeId, classes);
                }
            }
            Student Student1 = dao.find(changeId);//返回修改后的信息
            System.out.println("学号：" + Student1.getId() + " 姓名：" + Student1.getName() + " 性别：" + Student1.getSex() + " 学院：" + Student1.getAcademy() + " 专业：" + Student1.getMajor() + " 年级：" + Student1.getGrade() + " 班级：" + Student1.getClasses());
        }
    }

    //删除学生信息
    private void delete() {
        studentDao dao = new studentDao();
        System.out.println("请输入要删除的学生学号id：");
        Integer deleteId = Integer.valueOf(sc.next());
        if (!dao.judgeExist(deleteId)) {
            System.out.println("该学生不存在！");
        }
        else {
            dao.delete(deleteId);
            list();
        }
    }
}