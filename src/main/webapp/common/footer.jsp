<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<footer class="footer bg-dark text-center w-100 mt-5 fixed-bottom">
	<div class="container">
		<%-- <div class="footer-title text-white mt-4">てきとれ</div> --%>
		<ul class="footer-lists d-flex justify-content-center p-0 mt-3">
			<li class="footer-list"><a href="findAllServlet"
				class="text-white text-decoration-none">ホーム</a></li>
			<li class="footer-list"><a href="#"
				class="text-white text-decoration-none">お知らせ</a></li>
			<%
			User user = (User) session.getAttribute("user");
			if (user != null) {
			%>
			<li class="footer-list"><a href="myPage.jsp"
				class="text-white text-decoration-none">マイページ</a></li>
			<%
			} else {
			%>
			<li class="footer-list"><a href="login.jsp"
				class="text-white text-decoration-none">ログイン</li>
			<%
			}
			%>
		</ul>
		<div class="footer-copy text-white mb-4">Copyright &copy; 2023
			てきとれ All rights reserved.</div>
	</div>
</footer>

<!-- bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>