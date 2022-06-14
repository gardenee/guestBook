<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<h1>방명록</h1>
	<form action="/guestbook3/add" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="text" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">등록</button>
				</td>
			</tr>
		</table>
		
		
		<h2>방명록 리스트</h2>
		<c:forEach items="${gbList}" var="visit">
			<table border="1">
				<tr>
					<td>${visit.no}</td>
					<td>${visit.name}</td>
					<td>${visit.regDate}</td>
					<td><a href="/guestbook3/deleteForm/${visit.no}">[삭제]</a></td>
				</tr>
				<tr>
					<td colspan="4">${visit.content}</td>
				</tr>
			</table><br>
		</c:forEach>
		
	</form>
</body>
</html>