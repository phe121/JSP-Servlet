package teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.entity.Teacher;
import teacher.service.TeacherService;

@WebServlet(description = "新增一个老师的信息", urlPatterns = { "/AddTeacher" })
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddTeacher() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Type", "text/html;charset=UTF-8"); 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String currentPage = request.getParameter("currentPage");
		//String id =request.getParameter("id");
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String profession = request.getParameter("profession");
		String grade = request.getParameter("grade");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		
		Teacher teacher = new Teacher();
		//teacher.setId(Integer.valueOf(id));
		teacher.setName(name);
		teacher.setCollege(college);
		teacher.setProfession(profession);
		teacher.setGrade(grade);
		teacher.setSalary(Double.valueOf(salary));
		teacher.setAge(Integer.valueOf(age));
		
		TeacherService teacherService = new TeacherService();
		teacherService.addTeacher(teacher);

		request.getRequestDispatcher("./ShowAllTeacher?currentPage="+currentPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
