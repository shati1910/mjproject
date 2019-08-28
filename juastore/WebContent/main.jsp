<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	article {
	margin:auto;
	float:left;
	width:80%;
	padding:5%;
	}

	.mainimage{
	clear:both;
	background-color:blue;
	}
	.bestitems{
	background-color:red;
	}

	</style>
</head>
<body>
<jsp:include page="top.jsp"/>
<article>
	<div class="mainimage">
		<a href="#"><img src="images/sample.JPG"></a>
		<h1>메인 이미지 공간입니다.</h1>
	</div>
	<div class="bestitems">
	<h1>베스트 아이템이 들어갈 공간입니다.</h1><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	</div>
</article>
<jsp:include page="side.jsp"/>
<jsp:include page="bottom.jsp"/>
</body>
</html>