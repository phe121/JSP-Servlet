package teacher.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teacher.DBUtil;
import teacher.entity.Manager;

public class ManagerDao {
	public List<Manager> selectAllManager() {

		Connection connection = null;

		try {
			connection = DBUtil.getConnection();

			String sql = "select * from managers";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			List<Manager> managers = new ArrayList<Manager>();
			while (resultSet.next()) {

				Manager manager = new Manager();
				manager.setAccount(resultSet.getString("account"));
				manager.setPassword(resultSet.getString("password"));
		
				managers.add(manager);
			}
			return managers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
