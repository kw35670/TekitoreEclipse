<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
		<div class="container form-container">
			<form class="login-form bg-light shadow" action="loginServlet"
				method="post">
				<h2 class="form-title">ログイン</h2>
				<%
				// 処理メッセージとエラー判定を取得
				String message = (String) request.getAttribute("message");
				String error = (String) request.getAttribute("error");

				// 正常終了した場合のメッセージを表示
				if (message != null || error != null) {
				%>
				<div class="alert alert-danger" role="alert">
					<%=message%>
				</div>
				<%
				}
				%>
				<div class="mb-3">
					<label class="form-label">学籍番号</label> <input type="text"
						class="form-control" id="exampleInputEmail1" size="7"
						maxlength="7" aria-describedby="emailHelp" name="studentNumber" />

				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">パスワード</label>
					<input type="password" class="form-control"
						id="exampleInputPassword1" name="pass" />
				</div>
				<div class="warning text-primary">
					<a href="signUp.jsp" class="warning-account">アカウントを作成する</a>
				</div>
				<button type="submit" class="btn btn-primary">ログイン</button>
			</form>
		</div>
	</section>

	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>