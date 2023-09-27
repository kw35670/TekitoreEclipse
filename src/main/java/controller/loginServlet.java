package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDao;
import exception.CampusException;
import model.User;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// セッションの情報を破棄
		HttpSession session = request.getSession(false);
		session.invalidate();

		// login.jspに表示するメッセージをセット
		request.setAttribute("message", "ログアウトしました");

		// login.jspを表示
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sn = request.getParameter("studentNumber");
		String pass = request.getParameter("pass");
		String nextPage = null;

		try {
			userDao ud = new userDao();

			User user = ud.doLogin(sn, pass);

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			nextPage = "findAllServlet";

		} catch (CampusException e) {
			// ログインできなかった場合はメッセージをセットしてlogin.jspに表示
			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

			nextPage = "login.jsp";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}

}
