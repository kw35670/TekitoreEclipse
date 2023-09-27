<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page import="model.Item" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/selled.css" />
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
		<div class="container">
			<h1 class="se-title">出品した商品一覧</h1>
                <ul class="se-items">
                	<%
					ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("itemList");
					for (int i = 0; i < itemList.size(); i++) {
					%>
                    <li class="se-item">
                        <a href="itemServlet?itemId=<%= itemList.get(i).getItemId() %>" class="se-item-link">
                            <img
                                class="se-item-img"
                                src="/てきとれ/upload/<%=itemList.get(i).getItemImg().get(0)%>"
                                alt="商品の画像"
                            />
                            <div class="se-item-content">
                                <p class="se-item-title"><%= itemList.get(i).getItemTitle() %></p>
                                <div class="se-item-flex">
                                    <p class="se-item-price"><%= String.format("%,d", itemList.get(i).getItemPrice()) %>円</p>
                                    <p class="se-item-date"><%= itemList.get(i).getDateTime() %></p>
                                </div>
                            </div>
                        </a>
                    </li>
                    <% } %>
                </ul>
		</div>
	</section>

	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>