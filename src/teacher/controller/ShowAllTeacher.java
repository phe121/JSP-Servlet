package teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import teacher.entity.Teacher;
import teacher.service.TeacherService;

@WebServlet(description = "展示所有老师的信息", urlPatterns = { "/ShowAllTeacher" })
public class ShowAllTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAllTeacher() {
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
		Integer totalPages = (teachers.size() % 10 == 0) ? (teachers.size() / 10) : (teachers.size() / 10 + 1);

		//如果输入的页面有误，则跳到提示信息的页面。否则获取当前页的学生。
		if (Integer.valueOf(currentPage) == 0 || Integer.valueOf(currentPage) > totalPages) {
			String massage = "<P>页面跳转出错</p>";
			PrintWriter pw = response.getWriter();
			pw.println(massage);
		} else {
			List<Teacher> currentPageTheachers = teacherService.currentPageTeachers(teachers,
					Integer.valueOf(currentPage));
			request.setAttribute("currentPageTheachers", currentPageTheachers);
			request.setAttribute("teachers", teachers);
			// System.out.println(teachers.size());
			request.getRequestDispatcher("./jsp/showAllTeachers.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
