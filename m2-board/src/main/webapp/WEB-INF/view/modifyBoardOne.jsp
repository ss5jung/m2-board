<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>글수정</b>
			</h1>
			<hr>
			<div class="card mb-4">
				<div class="card-body">
					<form action="<%=request.getContextPath()%>/modifyBoardOne" method="post">
						<fieldset>
							<div style="margin-bottom: 5px">
								<label for="boardNo">boardNo</label>
								<input type="text" id="boardNo" name="boardNo" value="${boardNo}" readonly="readonly">
							</div>
							<div style="margin-bottom: 5px">
								<label for="boardWriter">작성자</label>
								<input type="text" class="form-control" id="boardWriter" name="boardWriter" value="${loginMember.memberId}" readonly="readonly">
							</div>
							<hr>
							<div style="margin-bottom: 5px">
								<label for="boardTitle">제목</label>
								<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목을 입력해 주세요">
							</div>
							<div style="margin-bottom: 5px">
								<label for="boardContents">내용</label>
								<textarea rows="5" class="form-control" id="boardContents" name="boardContents" style="width: 100%"></textarea>
							</div>
							<div>
								<button class="btn btn-primary" type="submit">수정</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>