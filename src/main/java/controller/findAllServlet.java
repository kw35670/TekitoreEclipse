package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.itemDao;
import exception.CampusException;
import model.Item;

/**
 * Servlet implementation class findAllServlet
 */
@WebServlet("/findAllServlet")
public class findAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Item> itemList = new ArrayList<>();
		try {
			itemDao iD = new itemDao();
			
			itemList = iD.findAllItem();
			request.setAttribute("itemList", itemList);
			
			
		} catch(CampusException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
		rd.forward(request, response);
	}

}
