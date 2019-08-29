<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/top.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	margin: auto;
	text-align: center;
}
td{
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty orderList }">
			<h1>주문 내용이 없습니다.</h1>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<td>주문번호</td>
						<td>주문날짜</td>
						<td>금액</td>
						<td>주문상태</td>
						<td>상세보기</td>
					</tr>
				</thead>
				<c:forEach var="list" items="${orderList }">
					<tr>
						<td>${list.order_num }</td>
						<td>${list.order_date }</td>
						<td>${list.pay }</td>
						<td>${list.order_state }</td>
						<td><a
							href="/juastore/orderDetail.ord?order_num=${list.order_num }">상세</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<jsp:include page="/side.jsp" />
	<jsp:include page="/bottom.jsp" />
</body>
</html>