<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/delete" method="post">
		<input type="hidden" name="no" value="${no}">
		<label for="pw">비밀번호</label>
		<input id="pw" type="text" name="password" value="">
		<button type="submit">확인</button>
	</form><br>
	
	<a href="/guestbook3/list">메인으로 돌아가기</a>
	
</body>
</html>