<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addBoard" method="post">
		<fieldset>
			<legend>글 작성</legend>
			<table border="1">
				<tr>
					<th>제목</th>
					<td><input type="text" id="boardTitle" name="boardTitle" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type="text" id="boardContents" name="boardContents" ></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="boardWriter" name="boardWriter" ></td>
				</tr>
			</table>
			<button type="submit">제출</button>
		</fieldset>
	</form>
</body>
</html>