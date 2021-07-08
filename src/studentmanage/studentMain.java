package studentmanage;
import java.util.*;
public class studentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentManager statusManager = new studentManager();

        while (true) {
            //界面123
            System.out.println("-------------");
            System.out.println("欢迎来到学生信息管理系统");
            System.out.println("0 显示全部学生信息");
            System.out.println("1 按学号搜索学生信息");
            System.out.println("2 增加学生信息");
            System.out.println("3 修改学生信息");
            System.out.println("4 删除学生信息");
            System.out.println("5 退出");
            System.out.println("------------");
            System.out.println("请选择：");

            int choice = sc.nextInt();
            //   try/catch
            try {
                if (choice == 5) {
                    System.out.println("您已退出该系统");
                    return;
                } else
                    statusManager.Manage(choice);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

