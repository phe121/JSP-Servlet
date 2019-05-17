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

@WebServlet(description = "删除一个老师的信息", urlPatterns = { "/DeleteTeacher" })
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTeacher() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String currentPage = request.getParameter("currentPage");
		String isSelectAll = request.getParameter("isSelectAll");
		String[] id = request.getParameterValues("id");
		TeacherService teacherService = new TeacherService();
		
		//求总的页数
		List<Teacher> teachers = teacherService.selectAllTeacher();
		Integer totalPages = (teachers.size() % 10 == 0) ? (teachers.size() / 10) : (teachers.size() / 10 + 1);

		for (int i = 1; i < id.length; i++) {
			// System.out.println(id[i]);
			teacherService.deleteTeacher(Integer.valueOf(id[i]));
		}
		
		//如果是最后一页，则返回上一页，否则返回当前页。
		if (Boolean.parseBoolean(isSelectAll) && Integer.valueOf(currentPage) == totalPages) {
			request.getRequestDispatcher("/ShowAllTeacher?currentPage=" + (Integer.valueOf(currentPage) - 1))
					.forward(request, response);
		} else {
			request.getRequestDispatcher("./ShowAllTeacher?currentPage=" + currentPage).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
