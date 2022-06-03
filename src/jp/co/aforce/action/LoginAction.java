package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Login;
import jp.co.aforce.dao.LoginDAO;

@WebServlet(urlPatterns = { "/jp/co/aforce/login/LoginAction" })
public class LoginAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		LoginDAO dao = new LoginDAO();
		try {
			Login login = dao.search(id, password);

			if (login != null) {
				session.setAttribute("login", login);
				request.getRequestDispatcher("/jsp/login-out.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/login-error.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
