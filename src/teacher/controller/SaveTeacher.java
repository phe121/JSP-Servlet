package teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.entity.Teacher;
import teacher.service.TeacherService;
/*
 * 保存新增的学生信息
 */
@WebServlet("/SaveTeacher")
public class SaveTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveTeacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id =request.getParameter("id");
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String profession = request.getParameter("profession");
		String grade = request.getParameter("grade");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		
		Teacher teacher = new Teacher();
		teacher.setId(Integer.valueOf(id));
		teacher.setName(name);
		teacher.setCollege(college);
		teacher.setProfession(profession);
		teacher.setGrade(grade);
		teacher.setSalary(Double.valueOf(salary));
		teacher.setAge(Integer.valueOf(age));
		
		TeacherService teacherService = new TeacherService();
		teacherService.updateTeacher(teacher);
		
		request.getRequestDispatcher("./ShowAllTeacher").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
