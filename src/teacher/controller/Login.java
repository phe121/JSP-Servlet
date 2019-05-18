package teacher.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.entity.Manager;
import teacher.service.ManagerService;

@WebServlet(description = "登录信息判断", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		ManagerService managerService = new ManagerService();
		List<Manager> managers = managerService.selectAllManager();

		boolean isCurrent = false;

		for (Manager manager : managers) {
			if (account.equals(manager.getAccount()) && password.equals(manager.getPassword())) {
				isCurrent = !isCurrent;
			}
		}
		if (isCurrent) {
			request.getRequestDispatcher("./ShowAllTeacher?currentPage=1").forward(request, response);
		} else {
			request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
