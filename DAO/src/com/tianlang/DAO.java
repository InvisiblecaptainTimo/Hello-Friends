package com.tianlang;

import com.entity.Emp;
import com.tianlang.jdbcutil.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    JDBCUtil util = new JDBCUtil();
    //增
    public int add(int empno,String ename,String JOB,int mgr,String HIREDATE,int SAL,int COMM,int DEPTNO){
        String sql = "insert into emp(empno,ename,JOB,mgr,HIREDATE,SAL,COMM,DEPTNO) value(?,?,?,?,?,?,?,?)";
        Connection con = util.getConnection();
        PreparedStatement pstm = util.getPrepareStatement(sql);
        int result = 0;
        try {
            pstm.setInt(1,empno);
            pstm.setString(2,ename);
            pstm.setString(3,JOB);
            pstm.setInt(4,mgr);
            pstm.setString(5,HIREDATE);
            pstm.setInt(6,SAL);
            pstm.setInt(7,COMM);
            pstm.setInt(8,DEPTNO);

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //删
    public void delete(int empno){
        String sql = "delete from emp where empno = ?";
        Connection con = util.getConnection();
        PreparedStatement pstm = util.getPrepareStatement(sql);

        try {
            pstm.setInt(1,empno);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("查无此人");
            e.printStackTrace();
        }finally {
            util.close();
        }
    }

    //改
    public void update(int empno){
        String sql = "update emp set empno = where";
        PreparedStatement pstm = util.getPrepareStatement(sql);
        try {
            pstm.setInt(1,empno);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查
    public List chaxun(){
        String sql = "select * from emp";
        Connection con = util.getConnection();
        PreparedStatement pstm = util.getPrepareStatement(sql);
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            rs = pstm.executeQuery();
            while (rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String JOB = rs.getString("JOB");
                int mgr = rs.getInt("mgr");
                String HIREDATE = rs.getString("HIREDATE");
                int SAL = rs.getInt("SAL");
                int COMM = rs.getInt("COMM");
                int DEPTNO = rs.getInt("DEPTNO");

                Emp emp = new Emp(empno,ename,JOB,mgr,HIREDATE,SAL,COMM,DEPTNO);
                list.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }return list;
    }
}
