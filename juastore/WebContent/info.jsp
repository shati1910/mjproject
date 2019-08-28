<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 관리자모드(회원 정보 보기)</title>
<style>
	table{
		margin:auto;
		width:400px;
		border:1px solid gray;
		text-align: center;
	}
</style>
</head>
<body>
<jsp:include page="top.jsp"/>
<table>
		<tr>
			<td>아이디 : </td>
			<td><%request.getParameter("id"); %></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><%request.getParameter("password"); %></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><%request.getParameter("name"); %></td>
		</tr>
		<tr>
			<td>이메일 : </td>
			<td><%request.getParameter("email"); %></td>
		</tr>
		<tr>
			<td>우편번호 : </td>
			<td><%request.getParameter("zip_code"); %>
		</tr>
		<tr>
			<td>상세주소 : </td>
			<td><%request.getParameter("address"); %></td>
		</tr>
		<tr>
			<td>전화번호 : </td>
			<td><%request.getParameter("phone"); %></td>
		</tr>
	<tr>
		<td colspan=2>
		<%if(session.getAttribute("id") == "admin") %>
			<a href="memberlist.mem">리스트로 돌아가기</a>
		<%else %>
			<a href="main.jsp">메인으로 돌아가기</a>
		</td>
	</tr>
</table>
<jsp:include page="side.jsp"/>
<jsp:include page="bottom.jsp"/>
</body>
</html>