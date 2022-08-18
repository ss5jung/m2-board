<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>회원정보</b>
			</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
			<div class="row">
				<table class="table table-hover">
					<thead class="table-active">
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>비밀번호</th>
							<th>회원탈퇴</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${loginMember.memberId}</td>
							<td>${loginMember.memberName}</td>
							<td><button class="btn btn-warning">비밀번호 수정</button></td>
							<td><button class="btn btn-danger">회원탈퇴</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>