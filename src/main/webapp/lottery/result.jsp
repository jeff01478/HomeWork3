<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../style/myStyle.css" rel="stylesheet">
</head>
<body>
	<h2>樂透號碼結果</h2>
	<%
		ArrayList[] resultNumbers = (ArrayList[])request.getAttribute("lotteryNumbers");
		for(ArrayList resultNum : resultNumbers) {
			out.println(resultNum + "</br></br>");
		}
	%>
	<a href="lottery.jsp">再試一次</a>&nbsp&nbsp<a href="../.">返回首頁</a>
</body>
</html>