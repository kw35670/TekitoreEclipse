package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.itemDao;
import exception.CampusException;
import model.Item;
import model.User;


@WebServlet("/itemSellBuy")
public class itemSellBuy extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Item> itemList = new ArrayList<>();
		try {
			itemDao iD = new itemDao();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			itemList = iD.findSelledItem(user.getStudentNumber());
			request.setAttribute("itemList", itemList);
			
			
		} catch(CampusException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("selled.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
