package teacher.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.entity.Teacher;
import teacher.service.TeacherService;

@WebServlet(description = "按年龄排序", urlPatterns = { "/SortByAge" })
public class SortByAge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SortByAge() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String currentPage = request.getParameter("currentPage");

		TeacherService teacherService = new TeacherService();
		List<Teacher> teachers = teacherService.selectAllTeacher();
		List<Teacher> currentPageTheachers = teacherService.currentPageTeachers(teachers, Integer.valueOf(currentPage));

		request.setAttribute("currentPageTheachers", currentPageTheachers);
		teacherService.sortByAge(currentPageTheachers);

		request.setAttribute("teachers", teachers);

		request.getRequestDispatcher("./jsp/showAllTeachers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
