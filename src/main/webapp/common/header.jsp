<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!-- header -->
<header class="header bg-light fixed-top shadow">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="findAllServlet"> <img
				src="./common/images/logo.png" width="100%" height="30"
				class="d-inline-block align-top" alt="" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse ms-auto" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<% 
						User user = (User)session.getAttribute("user");
						if(user != null) { 
					%>
					<li class="nav-item active"><a class="nav-link" href="findAllServlet">ホーム</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><%= ((User)session.getAttribute("user")).getFirstName() + " " +((User)session.getAttribute("user")).getLastName() %></a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="myPage.jsp">マイページ</a> <a
								class="dropdown-item" href="loginServlet">ログアウト</a>
						</div></li>
						<button type="button" class="btn btn-danger"
							onclick="location.href='exhibit.jsp'">出品する</button>
					<% } else {%>
						<li class="nav-item"><a class="nav-link" href="login.jsp">ログイン</a></li>
					<% } %>
					</li>
				</ul>
			</div>
		</nav>
	</div>
</header>