<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/head.jsp"></jsp:include>
<link rel="stylesheet" href="./css/account.css">
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>

	<section class="section">
            <div class="container form-container">
                <form action="signUpServlet" class="login-form bg-light shadow h-adr" method="post">
                    <span class="p-country-name" style="display: none"
                        >Japan</span
                    >
                    <h2 class="form-title text-center">アカウント新規作成</h2>

                    <div class="mb-3 row">
                        <label
                            for="studentNumber"
                            class="col-sm-2 col-form-label"
                            >学籍番号
                        </label>
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                id="studentNumber"
                                size="7"
                                maxlength="7"
                                placeholder="7桁の数字"
                                name="studentNumber"
                                required
                            />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label
                            for="inputPassword"
                            class="col-sm-2 col-form-label"
                            >パスワード</label
                        >
                        <div class="col-sm-10">
                            <input
                                type="password"
                                class="form-control"
                                id="inputPassword"
                                placeholder="半角英数字、8〜15字"
                                minlength="8"
                                maxlength="15"
                                name="pass"
                                required
                            />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="staticEmail" class="col-sm-2 col-form-label"
                            >メールアドレス</label
                        >
                        <div class="col-sm-10">
                            <input
                                type="email"
                                class="form-control"
                                id="staticEmail"
                                placeholder="例）email@example.com"
                                name="mailAddress"
                                required
                            />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="tel" class="col-sm-2 col-form-label"
                            >電話番号</label
                        >
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                id="tel"
                                placeholder="例）0901234567"
                                name="tel"
                                required
                            />
                        </div>
                    </div>
                    <!-- <div class="mb-3 row">
                        <label
                            for="inputPasswordSecond"
                            class="col-sm-2 col-form-label"
                            >パスワード(再入力)
                        </label>
                        <div class="col-sm-10">
                            <input
                                type="password"
                                class="form-control"
                                id="inputPasswordSecond"
                                minlength="8"
                                maxlength="15"
                                required
                            />
                        </div>
                    </div> -->
                    <div class="mb-3 row">
                        <h4>氏名</h4>
                        <label for="firstName" class="col-sm-2 col-form-label name-label-width"
                            >苗字
                        </label>
                        <div class="col-sm-3">
                            <input
                                type="text"
                                class="form-control"
                                id="firstName"
                                placeholder="例）情報"
                                name="firstName"
                                required
                            />
                        </div>
                        <label for="lastName" class="col-sm-2 col-form-label name-label-width"
                            >名前
                        </label>
                        <div class="col-sm-3">
                            <input
                                type="text"
                                class="form-control"
                                id="lastName"
                                placeholder="例）太郎"
                                name="lastName"
                                required
                            />
                        </div>
                    </div>
                    <div align="center">
                        <button type="submit" class="btn btn-primary center">
                            登録
                        </button>
                    </div>
                </form>
            </div>
        </section>

	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>