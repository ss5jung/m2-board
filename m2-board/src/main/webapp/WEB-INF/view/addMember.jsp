<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="euc-kr">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SAVER</title>
<link href="${pageContext.request.contextPath}/Bootdstrap/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4"><b>회원가입</b></h3>
								</div>
								<div class="card-body">
									<form action="<%=request.getContextPath()%>/addMember" method="post">
										<div class="form-floating mb-3">
											<input class="form-control" id="memberId" name="memberId" type="text" placeholder="아이디를 입력해주세요" />
											<label for="memberId">ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="memberName" name="memberName" type="text" placeholder="이름을 입력해주세요" />
											<label for="memberName">Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="memberPw" name="memberPw" type="password" placeholder="비밀번호를 입력해주세요" />
											<label for="memberPw">Password</label>
										</div>
										<div class="mt-4 mb-0">
											<div class="d-grid">
												<button class="btn btn-primary btn-block">Create Account</button>
											</div>
										</div>
									</form>
								</div>
								<div class="card-footer text-center py-3">
									<div class="small">
										<a href="login.html">Have an account? Go to login</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; PARKSJ Website 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/Bootdstrap/js/scripts.js"></script>
</body>
</html>
