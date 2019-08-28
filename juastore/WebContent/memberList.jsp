<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${pageInfo ne null }">
	<c:set var="listCount" value="${pageInfo.listCount }"/>
	<c:set var="nowPage" value="${pageInfo.page }"/>
	<c:set var="maxPage" value="${pageInfo.maxPage }"/>
	<c:set var="startPage" value="${pageInfo.startPage }"/>
	<c:set var="endPage" value="${pageInfo.endPage }"/>
</c:if>
<jsp:include page="top.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.memlist {
	margin: auto;
	width: 75%;
	text-align: center;
	border-collapse: collapse;
	clear: both;
}

.memlist td {
	border: none;
	font-size: 1.3em;
}

.total {
	margin: auto;
	width: 80%;
}

.memlist thead {
	background: #333;
	color: #fff;
}

.searchBox {
	float: right;
}

.Alignment {
	float: left;
}

.optionBox {
	margin: auto;
	width: 75%;
}
#pageList{
	margin:auto;
	width:500px;
	text-align:center;
	font-size:1.2em;	
}
#pageList a{
	text-decoration:none;
	color:black;
}
</style>
</head>
<body>
<form action="memberList.mem" name="memberlist">
	<div class="total">
		
		<div class="optionBox">
		<h1>회원 관리</h1>
			<div class="Alignment">
				<select id="search" name="search">
					<option value="idlist">ID순</option>
					<option value="joinlist">가입일순</option>
					<option value="paylist">구매금액순</option>
				</select>
				<input type="submit" value="정렬">
			</div>
			<div class="searchBox">
				<input type="text" id="findId" name="findId"> <input
					type="button" value="검색">
			</div>
		</div>
		<br><br>
		<table class="memlist">
		<c:choose>
			<c:when test="${listCount>0 }">
			<thead>
				<tr>
					<td>id</td>
					<td>가입일</td>
					<td>구매금액</td>
					<td>조회</td>
				</tr>
			</thead>
			<c:forEach var="list" items="${memlist }">
			<tr>
				<td>${list.id }</td>
				<td>${list.join_date }</td>
				<td>${list.paysum }</td>
				<td><input type="button" value="조회"></td>
			</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<section id="emptyArea">등록된 회원이 없습니다.</section>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
	<section id="pageList">
	<p>
		<c:choose>
			<c:when test="${nowPage<=1 }">
				[이전]&nbsp;
			</c:when>
			<c:otherwise>
				<a href="memberList.mem?page=${nowPage-1 }">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<c:forEach var="a" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${a==nowPage }">
					[${a }]
				</c:when>
				<c:otherwise>
					<a href="memberList.mem?page=${a }">[${a }]</a>&nbsp;
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${nowPage >= maxPage }">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="memberList.mem?page=${nowPage+1 }">[다음]</a>
			</c:otherwise>
		</c:choose>
	</section>
</form>
<jsp:include page="bottom.jsp"/>
</body>
</html>