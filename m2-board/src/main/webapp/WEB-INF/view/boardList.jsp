<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>공지사항</b>
			</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">공지사항</a></li>
				<li class="breadcrumb-item active">글목록</li>
			</ol>
			<hr>
			<div class="card mb-4">
				<div class="card-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회</th>
								<th>좋아요</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="b" items="${list}">
								<tr>
									<td>${b.boardNo}</td>
									<!-- b.getBoardNo() -->
									<td><a href="${pageContext.request.contextPath}/boardOne?boardNo=${b.boardNo}"> ${b.boardTitle} </a></td>
									<td>${b.boardWriter}</td>
									<td>${b.createDate}</td>
									<td>${b.boardViews}</td>
									<td>${b.boardNice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="container">
						<ul class="pagination justify-content-center">
							<c:if test="${currentPage > 1}">
								<li class="page-item"><a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}" class="page-link">이전</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="page-item"><a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}" class="page-link">다음</a></li>
							</c:if>
						</ul>
					</div>
					<div>
						<!-- ${pageContext.request.contextPath} 현재 내위치 -->
						<a href="${pageContext.request.contextPath}/addBoard"><button class="btn btn-secondary" style="float: right;">글쓰기</button></a>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>