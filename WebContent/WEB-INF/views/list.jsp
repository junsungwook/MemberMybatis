<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>회원목록보기</h1>
<h3><a href="insert.go">회원가입</a></h3>
<table>
	<tr>
	<th>아이디</th>
	<th>성명</th>
	<th>주소</th>
	<th>메모</th>
	<th>삭제</th>
	</tr>
	<c:forEach items="${list }" var="user">
	<tr>
	<td>${user.id }</td>
	<td><a href="myDetail.my?id=${user.id }">${user.name }</a></td>
	<td>${user.addr }</td>
	<td>${user.memo }</td>
	<td><a href="myDelete.my?id=${user.id }">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>