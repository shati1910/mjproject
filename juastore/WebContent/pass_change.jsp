<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="passChange.mem" name="passChange">
<table>
	<tr>
		<th>현재 비밀번호</th>
		<td><input type="password" name="passwordCk" id="passwordCk"></td>
	</tr>
	<tr>
		<th>새로운 비밀번호</th>
		<td><input type="password" name="newPass" id="newPass"></td>
	</tr>
	<tr>
		<th>비밀번호 확인</th>
		<td><input type="password" name="newPassChk" id="newPassChk"></td>
	</tr>
	<tr>
		<td><input type="submit" value="비밀번호 변경하기"></td>
	</tr>
</table>
</form>
</body>
</html>