<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.obj{
text-decoration:none;
color:black;
font-size: 1.3em;
}
</style>
</head>
<body>
<jsp:include page="top.jsp"/>
<p><a href="modify.mem" class="obj"><b>Profile</b></a><br>
개인정보조회 및 수정<br>
<p><a href="" class="obj"><b>Order</b></a><br>
주문내역 조회 / 취소 / 교환 / 반품 / 배송조회<br>
<p><a href="" class="obj"><b>Review</b></a><br>
내가 쓴 리뷰 관리<br>
<jsp:include page="side.jsp"/>
<jsp:include page="bottom.jsp"/>
</body>
</html>