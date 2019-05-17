package teacher.service;

import java.util.List;
import teacher.dao.TeacherDao;
import teacher.entity.Teacher;
/*
 * servcie层，调用dao层的方法
 */
public class TeacherService {

	public void addTeacher(Teacher teacher) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.addTeacher(teacher);
	}

	public void deleteTeacher(Integer id) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(id);
	}

	public void updateTeacher(Teacher teacher) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
	}

	public Teacher findTeacherById(Integer id) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.findTeacherById(id);
		return teacher;
	}

	public List<Teacher> selectAllTeacher() {
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teachers = teacherDao.selectAllTeacher();
		return teachers;
	}

	public void sortById(List<Teacher> teachers) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.sortById(teachers);
	}
	public void sortByAge(List<Teacher> teachers) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.sortByAge(teachers);
	}
	public List<Teacher> currentPageTeachers(List<Teacher> teachers,Integer currentPage){
		
		TeacherDao teacherDao = new TeacherDao();
		return teacherDao.currentPageTeachers(teachers, currentPage);
	}
}
