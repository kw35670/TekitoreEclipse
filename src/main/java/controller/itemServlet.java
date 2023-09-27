package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.itemDao;
import exception.CampusException;
import model.Item;
import model.User;

@WebServlet("/itemServlet")
@MultipartConfig
public class itemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int findItemNumber = Integer.parseInt(request.getParameter("itemId"));
		String message = null;

		try {
			itemDao itemDao = new itemDao();
			Item item = itemDao.findItem(findItemNumber);
			request.setAttribute("item", item);
		} catch (CampusException e) {
			message = e.getMessage();
			request.setAttribute("error", "true");
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("itemDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> itemImg = new ArrayList<String>();
		String itemTitle = request.getParameter("itemTitle");
		String itemState = request.getParameter("itemState");
		String itemExplanation = request.getParameter("itemExplanation");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));

		Collection<Part> parts = request.getParts();

		String path = "C:\\pleiades-2023-06-java-win-64bit-jre_20230617\\workspace\\てきとれ\\src\\main\\webapp\\upload";

		for (Part part : parts) {
			String name = getFileName(part);

			if (name != null && name.length() > 0) {
				itemImg.add(name);
				part.write(path + File.separator + name);
			}
		}

//		売却状況取得
		boolean saleState = false;
//		時間取得	
		Date date = new Date();
		long time = date.getTime();
		java.sql.Date Dtime = new java.sql.Date(time);
//		ログイン中のユーザーを取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Item item = new Item(0, itemImg, itemTitle, itemState, itemExplanation, itemPrice, saleState, Dtime,
				user.getStudentNumber());

		String message = null; // 処理失敗のメッセージを格納する変数
		try {
			itemDao iD = new itemDao();
			iD.exhibit(item);
			message = "商品を登録しました";
		} catch (CampusException e) {
			message = e.getMessage();
			request.setAttribute("error", "true");
			e.printStackTrace();
		}

		response.sendRedirect("findAllServlet");
	}

	private String getFileName(Part part) {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			String str = cd.trim();
			if (str.startsWith("filename")) {
				String str2 = str.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				File f = new File(str2);
				return f.getName();
			}
		}
		return null;
	}

}
