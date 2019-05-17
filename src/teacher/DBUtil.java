package teacher;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * 连接数据库
 */
public class DBUtil {
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/teacher";
		String userName = "root";
		String userPassword = "ddd306ddd";

		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, userName, userPassword);

		return connection;
	}
}
