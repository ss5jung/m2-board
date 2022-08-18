<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>공지사항</b>
			</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">공지사항</a></li>
				<li class="breadcrumb-item active">상세보기</li>
			</ol>
			<hr>
			<div class="card mb-4">
				<div class="card-body">
					<table class="table table-border">
						<tr>
							<th style="font-size: 40px" colspan="6">${board.boardTitle}</th>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${board.boardWriter}</td>
							<th>작성일</th>
							<td>${board.createDate}</td>
							<th>조회</th>
							<td>${board.boardViews}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="5">${board.boardContents}</td>
						</tr>
						<tr>
							<th><a href="${pageContext.request.contextPath}/boardOneNice?boardNo=${board.boardNo}&boardNice=${board.boardNice}"><i class="far fa-heart" style="color: red"></i></a>&nbsp;좋아요</th>
							<td colspan="6">${board.boardNice}</td>
						</tr>
					</table>
					<!-- 버튼 -->
					<div>
						<a href="${pageContext.request.contextPath}/modifyBoardOne?boardNo=${board.boardNo}"><button class="btn btn-primary" style="float: right; margin-left: 5px">수정</button></a>
						<a href="${pageContext.request.contextPath}/removeBoardOne?boardNo=${board.boardNo}"><button class="btn btn-danger" style="float: right;">삭제</button></a>
						<br><br><hr>
					</div>
					<!-- 버튼 -->
					<!-- 댓글 -->
					<p style="margin-top: 10px; margin-bottom: 15px; font-size: 20px">
						<b>댓글</b>
					</p>
					<form action="" method="">
						<textarea rows="5" style="width: 100%"></textarea>
						<button type="submit" class="btn btn-secondary" style="float: right;">등록</button>
					</form>
					<!-- 댓글 -->
				</div>
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>