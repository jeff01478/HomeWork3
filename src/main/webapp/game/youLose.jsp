<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style/myStyle.css" rel="stylesheet"/>
</head>
<body>
	<h1>You Lose</h1>
	<p>正確答案為 ${ guessGame.getLuckyNumber() }</p>
	<a href="gameController.do">再玩一次</a>&nbsp&nbsp<a href="../.">返回首頁</a>
	<% session.invalidate(); %>
</body>
</html>