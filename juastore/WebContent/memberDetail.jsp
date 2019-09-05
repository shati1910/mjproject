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

figure{
	margin: auto;
	width: 75%;
	font-size: 1.3em;
}
table{
	width: 100%;
	border-collapse: collapse;
}

td {
	border: 1px solid #ddd;
	padding: 5px;
}

th, thead {
	border: 1px solid #ddd;
	background: #eee;
	color: #A16C29;
	text-align: left;
}
.memberButton{
	float: right;
}

</style>
</head>
<body>
	<div class="total">
		<h1>회원 정보</h1>
		<figure>
			<figcaption>
				<p>회원정보</p>
				<div class="memberButton">
					<input type="button" value="수정" id="mod">
					<input type="button" value="삭제" id="mod">
				</div>
			</figcaption>
			<table>
				<tr>
					<th>아이디</th>
					<td>abcd</td>
				</tr>
				<tr>
					<th>가입날짜</th>
					<td>2018-08-22</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>abcd</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>010-1234-5678</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>abcd@abcd.com</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>11111<br> 대구<br> 11
					</td>
				</tr>
			</table>
		</figure>
		
		<br><br>
		
		<figure>
			<figcaption><p>주문내역</p></figcaption>
			<table>
				<thead>
					<tr>
						<td>주문번호</td>
						<td>주문날짜</td>
						<td>주문금액</td>
						<td>주문현황</td>
						<td>상세</td>
					</tr>
				</thead>
				<tr>
					<td>10</td>
					<td>2019-08-22</td>
					<td>39,000</td>
					<td>상품출고</td>
					<td><input type="button" value="상세"></td>
				</tr>
			</table>
		</figure>
		
		<br><br>
		
		<figure>
			<figcaption><p>작성한 문의</p></figcaption>
			<table>
				<thead>
					<tr>
						<td>번호</td>
						<td>상품</td>
						<td>제목</td>
						<td>작성 날짜</td>
					</tr>
				</thead>
				<tr>
					<td>17</td>
					<td>원피스</td>
					<td><a href="#">언제쯤 배송되나요?</a></td>
					<td>2019-08-22</td>
				</tr>
			</table>
		</figure>
		
		<br><br>
		
		<figure>
			<figcaption><p>작성한 후기</p></figcaption>
			<table>
				<thead>
					<tr>
						<td>상품</td>
						<td>제목</td>
						<td>작성 날짜</td>
					</tr>
				</thead>
				<tr>
					<td>원피스</td>
					<td><a href="#">좋네요</a></td>
					<td>2019-08-22</td>
				</tr>
			</table>
		</figure>
	</div>
</body>
</html>