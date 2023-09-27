<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Item"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/itemDetail.css" />
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<%
		Item item = (Item)request.getAttribute("item");
	%>
	<section class="section">
		<div class="container">
			<div class="id-wrapper">
				<div class="id-imgs">
					<%
				for(int i = 0; i < item.getItemImg().size(); i++){
				%>
					<img src="/てきとれ/upload/<%= item.getItemImg().get(i) %>" alt="商品の画像">
					<% } %>
				</div>
				<div class="id-content">
					<h2 class="id-title"><%= item.getItemTitle() %></h2>
					<p class="id-price"><%= String.format("%,d", item.getItemPrice()) %>円
					</p>
					<p class="id-state">
						商品の状態：<%= item.getItemExplanation() %></p>
					<h4 class="id-ex-title">商品の説明</h4>
					<p class="id-explanation"><%= item.getItemState() %></p>
					<p class="id-date">出品日時：<%= item.getDateTime() %></p>
					<p class="id-name">出品者学籍番号：<%= item.getStudentNumber() %></p>
					<form action="itemDetail" method="post" class="id-btns">
						<button class="btn btn-secondary" type="button"
							onclick="location.href='findAllServlet'">戻る</button>
						<%
						    	User user = (User)session.getAttribute("user");
						    	if(item.getStudentNumber().equals(user.getStudentNumber()) != true) {
						    %>
						<button type="button" class="btn btn-danger">購入する</button>
						<% } else { %>
						<button type="button" class="btn btn-danger"
							onclick="location.href='exhibit.jsp'">編集する</button>
						<% } %>
					</form>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>