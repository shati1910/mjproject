<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="utf-8"/>

<c:set var="openInit" value="${!empty param.openInit ? 'true' : 'false' }" />
<c:set var="checkId" value="${param.id }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function init(){
	if(${openInit }){
		document.getElementById("id").value=opener.document.getElementById("id").value;
	}
}
function ok(v){
	opener.idcheck=v.trim();
	opener.document.getElementById("id").value=v;
	opener.chkId=true;
	window.close();
}
</script>
</head>
<body onload="init()">
<form action="memberIdCheck.mem" method="post" name=f>
<input type="text" name="id" id="id"/>
<input type="submit" value="중복확인"/>
</form>

<c:if test="${usebleId ne null && id ne '' }">
	<hr>
<c:choose>
<c:when test="${usebleId }">
	<h3>${id } 는 사용 가능한 아이디 입니다. <a href='#' onclick="ok('${id}')">사용하기</a></h3>
</c:when>
<c:otherwise>
	<h3>${id } 는 사용 불가능한 아이디입니다. 다시 검색하세요.</h3>
</c:otherwise>	
</c:choose>
</c:if>
</body>
</html>
