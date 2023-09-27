package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import exception.CampusException;
import model.User;


@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sn = request.getParameter("studentNumber");
		String pass = request.getParameter("pass");
		String ma = request.getParameter("mailAddress");
		String tel = request.getParameter("tel");
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		
		String nextPage = null;
		
		User user = new User(sn, pass, fn, ln, tel, ma);
		System.out.println(sn + pass + fn + ln + tel + ma);
		
		try {
			userDao ud = new userDao();
			ud.signUp(user);
			
			nextPage = "login.jsp";
		} catch(CampusException e) {
			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

			// ログイン画面へ遷移する準備
			nextPage = "signUp.jsp";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}
}
