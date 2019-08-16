<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<table>
	<tr>
		<td>
			<label for="id">아이디</label>
		</td>
		<td>
			<input type="text" name="id" id="id">
		</td>
	</tr>
	<tr>
		<td>
			<label for="password">비밀번호</label>
		</td>
		<td>
			<input type="password" name="password" id="password">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="로그인">
		</td>
	</tr>
</table>
<a href="#">id/password찾기</a>&nbsp;&nbsp;
<a href="#">회원가입</a>
</form>
</body>
</html>