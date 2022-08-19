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
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">
										<b>회원탈퇴</b>
									</h3>
								</div>
								<div class="card-body">
									<form action="<%=request.getContextPath()%>/removeMember" method="post">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" id="id" name="id" value="${loginMember.memberId }" readonly="readonly" />
											<label for="inputEmail">ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="password" id="pw" name="pw" />
											<label for="inputPassword">Password</label>
											<span class="text-center" style="color: red; font-size: 14px">회원탈퇴를 원하시면 비밀번호를 입력하세요</span>
										</div>
										
										<div class="d-flex align-items-center justify-content-between mt-4 mb-0">
											<button type="submit" class="btn btn-danger">회원탈퇴</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/Bootdstrap/js/scripts.js"></script>
</body>
</html>
