
import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            //加载驱动
            //DriverManager.registerDriver(new Driver()); 会导致加载两次驱动  源代码中加载一次  在程序中又加载一次
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_sql", "root", "root");
            //创建执行SQL语句的对象，并执行SQL
            String sql = "select * from user1";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String proName = resultSet.getString("proNmae");

                System.out.println(id + "   " + username + "    " + proName);
            }
            //释放资源
            statement.close();
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
