<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제폼</title>
</head>
<body>
	<form action="./gbc" method="post">
		<input type="hidden" name="action" value="delete">
		<input type="hidden" name="no" value=${no}>
		<label for="pw">비밀번호</label>
		<input id="pw" type="text" name="pw" value="">
		<button type="submit">확인</button>
	</form>
	<a href="/guestbook2/gbc?action=addList">메인으로 돌아가기</a>
</body>
</html>
