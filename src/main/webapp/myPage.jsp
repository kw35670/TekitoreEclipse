<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/myPage.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
		<div class="container">
			<% 
				User user = (User)session.getAttribute("user");
			%>
			<h1 class="user-name"><%= ((User)session.getAttribute("user")).getFirstName() + " " +((User)session.getAttribute("user")).getLastName() %></h1>
			<h4 class="user-number">学籍番号：<%= ((User)session.getAttribute("user")).getStudentNumber() %></h4>
			<ul class="my-content-wrappper">
				<li><a href="itemSellBuy" class="my-content"> <i
						class="fa-solid fa-vr-cardboard"></i>
						<p class="my-exhibit my-content-child">出品した商品一覧</p>
				</a></li>
				<li><a href="itemSellBuy" class="my-content"> <i
						class="fa-solid fa-bag-shopping"></i>
						<p class="my-buyed my-content-child">購入した商品一覧</p>
				</a></li>
				<li><a href="" class="my-content"> <i
						class="fa-regular fa-user"></i>
						<p class="my-personal my-content-child">個人情報変更</p>
				</a></li>
			</ul>
		</div>
	</section>

	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>