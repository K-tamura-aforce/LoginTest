package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/jp/co/aforce/login/LogoutAction" })
public class LogoutAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
			request.getRequestDispatcher("/jsp/logout-out.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/jsp/logout-error.jsp").forward(request, response);

		}
	}
}
