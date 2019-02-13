<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="myUpdate.my" method="post">
아이디 : <input type="text" id="id" name="id" value="${user.id }"><br>
비밀번호 : <input type="text" id="pass" name="pass" value="${user.pass }"><br>
이름: <input type="text" id="name" name="name" value="${user.name }"><br>
주소 : <input type="text" id="addr" name="addr" value="${user.addr }"><br>
메모 : <textarea rows="8" cols="8" id="memo" name="memo">${user.memo }</textarea><br>
<input type="submit" value="수정">
</form>
</body>
</html>