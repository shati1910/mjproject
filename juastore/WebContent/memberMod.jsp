<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top_menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.total {
	margin: auto;
	width: 80%;
}
.tableButton{
	margin: auto;
	width: 75%;
}
#modtable{
	width: 75%;
	border-collapse: collapse;
	font-size: 1.3em;
	margin: auto;
}
#content {
	border: 1px solid #ddd;
	padding: 5px;
}

#title {
	border: 1px solid #ddd;
	background: #eee;
	color: #A16C29;
	text-align: left;
}
</style>
</head>
<body>
<div class="total">
	<h1>정보수정</h1>
	<form action="#">
		<table id="modtable">
			<tr>
				<th class="title">아이디</th>
				<td class="content">abcd</td>
			</tr>
			<tr>
				<th class="title">이름</th>
				<td class="content"><input type="text" value="abcd"></td>
			</tr>
			<tr>
				<th class="title">연락처</th>
				<td class="content"><input type="text" value="010-1234-5678"></td>
			</tr>
			<tr>
				<th class="title">이메일</th>
				<td><input type="text" value="abcd@abcd.com"></td>
			</tr>
			<tr>
				<th class="title">주소</th>
				<td class="content">
					<input type="text" value="11111"><br>
					<input type="text" value="대구"><br>
					<input type="text" value="11">
			</tr>
		</table>
		<div class="tableButton">
			<input type="submit" value="수정">
			<input type="reset" value="다시작성">
		</div>
	</form>
</div>
</body>
</html>