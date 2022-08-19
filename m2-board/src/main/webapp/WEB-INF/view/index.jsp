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
			<!-- 회원정보 -->
			<div class="row">
				<table class="table table-bordered ">
					<tr>
						<th>아이디</th>
						<td>${loginMember.memberId }</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${loginMember.memberName }</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><button class="btn btn-primary">비밀번호 수정</button></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${loginMember.memberPhone }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${loginMember.memberAddress }</td>
					</tr>
				</table>
				<div style="display: inline-block; margin: 0 5px 15px 0; float: right;">
					<a href="${pageContext.request.contextPath}/modifyMember"><button class="btn btn-primary" style="margin: 0 0 5px 0; float: right;">정보수정</button></a> 
					<a href="${pageContext.request.contextPath}/removeMember"><button class="btn btn-danger" style="margin: 0 5px 5px 0; float: right;">회원탈퇴</button></a>
				</div>
				<hr>
				<br>
			</div>
			<!-- 회원정보 -->
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