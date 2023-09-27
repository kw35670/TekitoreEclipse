<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/exhibit.css" />
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
		<div class="container form-container">
			<form class="login-form bg-light shadow" action="itemServlet"
				method="post" enctype="multipart/form-data">
				<h2 class="form-title text-center">教科書の出品</h2>
				<div class="mb-3">
					<div class="exImg" id="preview"></div>
					<label for="exhibitImg" class="form-label">出品画像(最大５枚まで)</label><br>
					<input type="file" class="form-control" id="exhibitImg"
						name="itemImg" multiple required />
					<button type="button" id="clear" class="btn btn-secondary">クリア</button>
				</div>
				<h3 class="mt-5 mb-3">教科書の詳細</h3>
				<div class="mb-3">
					<label for="itemTitle" class="form-label">教科書タイトル</label> <input
						type="text" class="form-control" id="itemTitle" maxlength="20"
						name="itemTitle" required />
				</div>
				<div class="mb-3">
					<label for="itemState" class="form-label">教科書の状態</label>
					<select class="form-control" id="itemState" name="itemState"
						required>
						<option value="" hidden>-----選択してください-----</option>
						<option value="新品未使用">新品未使用</option>
						<option value="ほぼ未使用">ほぼ未使用</option>
						<option value="目立った傷やよごれなし">目立った傷やよごれなし</option>
						<option value="傷や汚れあり">傷や汚れあり</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="itemExplanation" class="form-label">教科書の説明（200字以内）</label>
					<textarea class="form-control" id="itemExplanation" rows="10" name="itemExplanation"
						maxlength="200"
						placeholder="教科書の状態、都合がつく時間帯など詳しく記入しましょう。　
                            
記入例）--------------------
（講義名）にて半年ほど使用しました。
付録は使用しておらず、書き込み等もありません。
目立った傷やよごれはないですが神経質な方はご遠慮ください。

値下げ不可
取り置き不可

都合が付きやすい時間帯
　月曜日　10：30～12：55
　木曜日　14：25～16：15
　火、金曜日は日中対応可能
　土、日曜日は応相談
------------------------------"
						required></textarea>
				</div>
				<h3 class="mt-5 mb-3">販売価格</h3>
				<div class="mb-3" id="textPriceWrap">
					<label for="itemPrice" class="form-label">販売価格（1,000,000円以下）</label>
					<input type="number" class="form-control" id="itemPrice" min="1"
						max="1000000" step="1" name="itemPrice" placeholder="￥" required />
					<!-- エラーメッセージ設定要素 -->
					<p class="text-danger" id="errorMsg"></p>
					<p id="profit">販売利益：</p>
				</div>
				<div class="buttons">
					<button class="btn btn-secondary" type="button"
						onclick="location.href='findAllServlet'">戻る</button>
					<button type="submit" class="btn btn-primary">出品</button>
				</div>
			</form>
		</div>
	</section>

	<jsp:include page="./common/footer.jsp"></jsp:include>

	<!-- JavaScript -->
	<script src="./js/load.js"></script>
	<script src="./js/fileUpload.js"></script>
	<!-- <script src="./js/price.js"></script> -->
</body>
</html>