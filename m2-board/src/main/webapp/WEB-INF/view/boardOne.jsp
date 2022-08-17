<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>No.</th>
			<td>${board.boardNo}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.boardTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.boardContents}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.boardWriter}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.createDate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.boardViews}</td>
		</tr>
		<tr>
			<th>좋아요</th>
			<td>${board.boardNice}<a href="${pageContext.request.contextPath}/boardOneNice?boardNo=${board.boardNo}&boardNice=${board.boardNice}"><button class="btn btn-xs btn-success">좋아요</button></a></td>
		</tr>
	</table>
</body>
</html>