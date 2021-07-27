package com.tianlang;

import java.sql.*;

/*  一：注册驱动
    二：连接数据库
    三：获取数据库操作对象
    四：执行sql语句
    五：处理查询结果集
    六：释放资源
 */
public class 预编译 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tianlang";
        String user = "root";
        String password = "Lance2497";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); //注册驱动
            conn = DriverManager.getConnection(url,user,password);   //连接数据库
            String sql = "insert into emp(empno,ename,JOB,mgr,HIREDATE,SAL,COMM,DEPTNO) values(?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,1000);
            pstm.setString(2,"田浪");
            pstm.setString(3,"老总");
            pstm.setInt(4,0);
            pstm.setString(5,"2021-03-28");
            pstm.setInt(6,9999);
            pstm.setInt(7,800);
            pstm.setInt(8,40);

            pstm.addBatch();
            pstm.executeBatch();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstm!=null){
                try {
                    pstm.close();
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
