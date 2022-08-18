<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@include file="./header.jsp"%>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">
				<b>Dashboard</b>
			</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
			<!-- 로그인 정보 -->
			<div class="row">
				<p><b>${loginMember.memberName}</b>님</p>
			</div>
			<!-- /로그인 정보 -->
			<div class="row">
				<table class="table table-striped">
					<caption></caption>
				</table>
			</div>
		</div>
	</main>
	<%@include file="./footer.jsp"%>