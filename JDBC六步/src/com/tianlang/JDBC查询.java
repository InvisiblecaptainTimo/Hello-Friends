package com.tianlang;

import java.sql.*;

/*  一：注册驱动
    二：连接数据库
    三：获取数据库操作对象
    四：执行sql语句
    五：处理查询结果集
    六：释放资源

 */
public class JDBC查询 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tianlang";
        String user = "root";
        String password = "Lance2497";
        String sql = "select * from emp";

        Connection conn = null;
        PreparedStatement pstm = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); //注册驱动
            conn = DriverManager.getConnection(url,user,password);   //连接数据库
            stm = conn.createStatement(); //获取操作对象stm
            rs = stm.executeQuery(sql); //用操作对象执行sql语句
            // 查询结果集
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
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
