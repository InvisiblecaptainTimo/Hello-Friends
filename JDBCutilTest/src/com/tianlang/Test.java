package com.tianlang;

import com.tianlang.jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        JDBCUtil util = new JDBCUtil();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from emp";
        try {
            conn = util.getConnection();
            stm = util.getPrepareStatement(sql);
            rs = stm.executeQuery(sql);
            while (rs.next()){
                String empno = rs.getString(1);
                String ename = rs.getString(2);
                String JOB = rs.getString(3);
                String mgr = rs.getString(4);
                String HIREDATE = rs.getString(5);
                String SAL = rs.getString(6);
                String COMM = rs.getString(7);
                String DEPTNO = rs.getString(8);
                System.out.println(empno+","+ename+","+JOB+","+mgr+","+HIREDATE+","+SAL+","+COMM+","+DEPTNO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
    }
}
