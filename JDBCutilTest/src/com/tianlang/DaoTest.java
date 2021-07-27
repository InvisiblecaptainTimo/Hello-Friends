package com.tianlang;

import com.entity.Emp;
import java.util.List;
import java.util.Scanner;

public class DaoTest {
    public static void main(String[] args) {
        DAO dao = new DAO();
        int result = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("*************欢迎使用员工管理系统*************");
        System.out.println("*************员工信息导入请选择一*************");
        System.out.println("*************员工信息删除请选择二*************");
        System.out.println("*************员工信息修改请选择三*************");
        System.out.println("*************员工信息查询请选择四*************");

        result = sc.nextInt();
        if (result == 1){
            System.out.println("请输入新员工编号：");
            int empno = sc.nextInt();
            System.out.println("请输入新员工姓名：");
            String ename = sc.next();
            System.out.println("请输入新员工工作：");
            String job = sc.next();
            System.out.println("请输入新员工领导编号：");
            int mgr = sc.nextInt();
            System.out.println("请输入新员工入职日期：");
            String hiredate = sc.next();
            System.out.println("请输入新员工工资：");
            int sal = sc.nextInt();
            System.out.println("请输入新员工津贴：");
            int comm = sc.nextInt();
            System.out.println("请输入新员工部门编号");
            int deptno = sc.nextInt();

            dao.add(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        }
        if (result == 2){
            System.out.println("请输入要删除的员工编号");
            int ename = sc.nextInt();
            dao.delete(ename);
            if (result == 2){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
        if (result == 3){
            System.out.println("请输入要更改的员工编号");
            int empno = sc.nextInt();
            dao.update(empno);
        }
        if (result == 4){
            List<Emp> emplist = dao.chaxun();
            for (Emp emp:emplist){
                System.out.println("员工编号："+emp.getEmpno()+"    "+"员工姓名:"+emp.getEname());
            }
        }
    }
}
