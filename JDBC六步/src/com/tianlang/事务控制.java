package com.tianlang;

import java.sql.*;

/*  一：注册驱动
    二：连接数据库
    三：获取数据库操作对象
    四：执行sql语句
    五：处理查询结果集
    六：释放资源
 */
public class 事务控制 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/tianlang";
        String user = "root";
        String password = "Lance2497";

        String sql_1 = "delete from emp where ename = '田浪'";
        String sql_2 = "delete from emp where ename = '毛不易掉的牙刷'";

        Connection conn = null;
        PreparedStatement pstm = null;

        Class.forName("com.mysql.jdbc.Driver"); //注册驱动
        conn = DriverManager.getConnection(url,user,password);   //连接数据库
        conn.setAutoCommit(false);  //向SQL服务器发送命令 “start transaction”

        pstm = conn.prepareStatement(" ");

        try {
            pstm.executeUpdate(sql_1);
            pstm.executeUpdate(sql_2);
            conn.commit();
            System.out.println("删除成功！");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("删除失败！");
        }finally {
            if (pstm != null){
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