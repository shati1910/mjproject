<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	aside{
	width:100px;
	float:right;
	}
	.sidebar{
	position:fixed;
	top:350px;
	right:50px;
	bottom:200px;
	}
	.here{
	position:absolute;
	}
	#top{
	top:0;	
	}
	.quickmenu{
	background-color:black;
	color:white;
	text-align:center;
	}
	.deco{
	text-decoration:none;
	color:white;
	}
</style>
</head>
<body>
<div class="here" id="top"></div>
<aside class="sidebar">
	<table>
	<thead class="quickmenu">
	<tr><td>QUICK MENU</td></tr>
	</thead>
	<tr>
	<td>
	사이드바
	</td>
	</tr>
	<tr>
	<td>
	내용이
	</td>
	</tr>
	<tr>
	<td>
	들어갑니다
	</td>
	</tr>
	<tr>
	<td>
	<img src="images/sample.JPG" width="100px"/>
	</td>
	</tr>
	<tfoot class="quickmenu">
	<tr>
	<td>
	<a href="#top" class="deco">top</a>
	</td>
	</tr>
	</tfoot>
	</table>
</aside>
</body>
</html>