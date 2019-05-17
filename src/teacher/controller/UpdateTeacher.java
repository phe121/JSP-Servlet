package teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.entity.Teacher;
import teacher.service.TeacherService;

@WebServlet(description = "修改一个老师的信息", urlPatterns = { "/UpdateTeacher" })
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateTeacher() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.findTeacherById(Integer.valueOf(id));
		if(teacher == null) {
			return;
		}
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("./jsp/updateTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
