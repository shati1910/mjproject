<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.userId ne 'admin'}">
	<script>
		alert('권한이 없습니다!!');
		history.back();
	</script>
</c:if>
