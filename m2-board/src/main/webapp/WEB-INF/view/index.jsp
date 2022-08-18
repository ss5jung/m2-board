<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>${loginMember.memberName}</b>(${loginMember.memberId})
			</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">내정보</li>
			</ol>
			<div class="row">
				<!-- 작성글 -->
				<table class="table table-hover">
					<thead class="table-active">
						<tr>
							<th>제목</th>
							<th>작성일</th>
							<th>조회</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${list}">
							<tr>
								<td><a href="${pageContext.request.contextPath}/boardOne?boardNo=${b.boardNo}">${b.boardTitle }</a></td>
								<td>${b.createDate }</td>
								<td>${b.boardViews }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 작성글 -->
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>