import com.ou.utils.JdbcUtils;

import java.sql.*;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        System.out.println("数据库连接对象"+connection);
        String sql = "select * from news_cate";
        Statement preparedStatement = connection.createStatement();
        ResultSet rs = preparedStatement.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println("id"+id+","+"name"+name);

        }

    }
}
