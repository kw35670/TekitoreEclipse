<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Item"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/itemList.css" />
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
		<div class="container">
			<div class="row row-cols-1 row-cols-md-4 g-4 mt-5">
				<%
				ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("itemList");
				for (int i = 0; i < itemList.size(); i++) {
				%>
				<a class="col" href="itemServlet?itemId=<%= itemList.get(i).getItemId() %>">
					<div class="card h-auto">
						<div class="item-img-wrap">
							<img
								src="/てきとれ/upload/<%=itemList.get(i).getItemImg().get(0)%>"
								class="card-img-top" alt="商品の画像（一枚目）" />
						</div>
						<div class="card-body">
							<h5 class="card-title"><%=itemList.get(i).getItemTitle()%></h5>
							<p class="card-text"><%= String.format("%,d", itemList.get(i).getItemPrice()) %>円
							</p>
						</div>
						<div class="card-footer">
							<small class="text-muted"><%=itemList.get(i).getDateTime()%></small>
						</div>
					</div>
				</a>
				<%
				}
				%>
			</div>
		</div>
	</section>

	<%-- 出品ボタン --%>
	<a href="./exhibit.jsp" class="exhibitBtn">
		<div class="post-btn">
			<i class="fa-solid fa-plus"></i>
		</div>
	</a>
	
	<!-- JavaScript -->
	<script src="./js/reLoad.js"></script>
	
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>