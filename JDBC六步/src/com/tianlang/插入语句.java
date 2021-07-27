import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class 插入语句 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC配置文件");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("Driver");

        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
//		1：注册驱动，但我貌似发现不需要注册驱动也能加载到
        try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());	//	因为Driver中有个静态代码块，只要加载这个类就可以注册驱动，所以采用反射机制来写
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//		2：获取连接
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("MySQL数据库连接成功！"+conn);

//		3：获取数据库操作对象。Statement是专门用来执行 sql 语句的
            stm = conn.createStatement();

//		4：执行 sql。
            String sql01 = "select * from emp";
            String sql02 = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(1001,'毛不易掉的牙刷','程序员',null,'2021-02-21',8000,500,40)";
            String sql03 = "delete from emp where emp.ename='毛不易掉的牙刷'";
            stm.executeUpdate(sql03);
            int count = stm.executeUpdate(sql02);
            System.out.println(count == 1? "插入成功" : "插入失败");
//		5：处理查询结果集			
            //ResultSet就是结果集，全部提取出来需要迭代
            rs = stm.executeQuery(sql01);
            while(rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

//		6：释放资源，写在finally中，并且要遵循从小到大的顺序依次关闭，因为有异常，所以还要注意分别对其 try catch,即：先关查询结果集，再关数据库操作对象，最后关连接
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
 