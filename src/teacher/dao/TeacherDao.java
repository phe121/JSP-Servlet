package teacher.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import teacher.DBUtil;
import teacher.entity.Teacher;
/*
 * 数据访问层，对数据的操作
 */
public class TeacherDao {

	public void addTeacher(Teacher teacher) {

		Connection connection = null;
		try {

			connection = DBUtil.getConnection();
			String sql = "insert into teacher(name,college,profession,grade,salary,age) values ('%s','%s','%s','%s','%f','%d')";
			sql = String.format(sql, teacher.getName(), teacher.getCollege(), teacher.getProfession(),
					teacher.getGrade(), teacher.getSalary(), teacher.getAge());

			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteTeacher(Integer id) {

		Connection connection = null;
		try {

			connection = DBUtil.getConnection();
			String sql = "delete from teacher where id = '%d'";
			sql = String.format(sql, id);

			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateTeacher(Teacher teacher) {

		Connection connection = null;
		try {

			connection = DBUtil.getConnection();
			String sql = "update teacher set name = '%s',college = '%s',profession = '%s',grade = '%s',salary = '%f',age = '%d' where id = '%d' ";
			sql = String.format(sql, teacher.getName(), teacher.getCollege(), teacher.getProfession(),
					teacher.getGrade(), teacher.getSalary(), teacher.getAge(), teacher.getId());

			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Teacher findTeacherById(Integer id) {

		Connection connection = null;
		try {

			connection = DBUtil.getConnection();
			String sql = "select * from teacher where id = '%d'";
			sql = String.format(sql, id);

			Statement statement = connection.createStatement();
			//返回结果集
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setCollege(resultSet.getString("college"));
				teacher.setProfession(resultSet.getString("profession"));
				teacher.setGrade(resultSet.getString("grade"));
				teacher.setSalary(resultSet.getDouble("salary"));
				teacher.setAge(resultSet.getInt("age"));

				return teacher;
			}
			return null;
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

	public List<Teacher> selectAllTeacher() {

		Connection connection = null;

		try {
			connection = DBUtil.getConnection();

			String sql = "select * from teacher";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			List<Teacher> teachers = new ArrayList<Teacher>();
			while (resultSet.next()) {

				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setCollege(resultSet.getString("college"));
				teacher.setProfession(resultSet.getString("profession"));
				teacher.setGrade(resultSet.getString("grade"));
				teacher.setSalary(resultSet.getDouble("salary"));
				teacher.setAge(resultSet.getInt("age"));

				teachers.add(teacher);
			}
			return teachers;
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

	//按照id排序
	public void sortById(List<Teacher> teachers) {
		Collections.sort(teachers, new Comparator<Teacher>() {

			@Override
			public int compare(Teacher o1, Teacher o2) {
				return o1.getId().compareTo(o2.getId());
			}

		});
	}

	//按照年龄排序
	public void sortByAge(List<Teacher> teachers) {
		Collections.sort(teachers, new Comparator<Teacher>() {

			@Override
			public int compare(Teacher o1, Teacher o2) {
				return o1.getAge().compareTo(o2.getAge());
			}

		});
	}

	//获取当前页的老师
	public List<Teacher> currentPageTeachers(List<Teacher> teachers, Integer currentPage) {
		List<Teacher> newTeachers = new ArrayList<Teacher>();
		Integer teacherNumbers = teachers.size();
		//Integer totalPages = (teacherNumbers % 10 == 0) ? (teacherNumbers / 10) : (teacherNumbers / 10 + 1);

		//如果当前学生小于10，直接将其余学生加入newTeachers，否则新增10个到newTeachers
		if (currentPage * 10 > teacherNumbers) {
			for (int i = (currentPage - 1) * 10; i < teacherNumbers; i++) {
				newTeachers.add(teachers.get(i));
			}
		} else {
			for (int i =  (currentPage - 1) * 10; i < ( (currentPage - 1) * 10 + 10); i++) {
				newTeachers.add(teachers.get(i));
			}
		}

		return newTeachers;
	}
}
