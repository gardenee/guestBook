<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록입니다</title>
</head>
<body>
	<form action="./gbc" method="post">
		<input type="hidden" name="action" value="add">
		<table border="1">
		<tr>
			<td><label for="name">이름</label></td>
			<td><input id="name" type="text" name="name" value=""></td>
			<td><label for="pw">비밀번호</label></td>
			<td><input id="pw" type="text" name="pw" value=""></td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<td><button type="submit">등록</button></td>
		</tr>
	</table></form><br>
	<c:forEach items="${gList}" var="vo">
		<table border="1">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name}</td>
				<td>${vo.regDate}</td>
				<td><a href="./gbc?action=deleteForm&no=${vo.no}">[삭제]</a></td> 
			</tr>
			<tr>
				<td colspan="4">${vo.content}</td>
			</tr>
		</table><br>
	</c:forEach>
	
</body>
</html>