<%@page import="java.util.LinkedList"%>
<%@page import="java.net.http.HttpRequest"%>
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
	<h2>樂透選號</h2>
	<ul style="color: red; font-size: 0.8em">
		<table style="margin: auto">
			<% 
				LinkedList<String> errorMsgs = (LinkedList)request.getAttribute("errors"); 
				if(errorMsgs != null) {
					for(String error : errorMsgs) {
						out.println("<tr><td><li>" + error + "</li></td></tr>");
					}
				}
			%>
		</table>
	</ul>
	<form action="lotteryController.do" method="post">
		<table style="margin:auto; text-align:right">
			<tr><td>數組</td><td><input type="text" placeholder="請輸入整數" name="groups" value="${ param.groups }" /></td>
			<tr><td>排除的數字</td><td><input type="text" placeholder="每個數字需用空格隔開" name="filterNum" value="${ param.filterNum }" /></td>
		</table>
		<input style="margin:auto" type="submit" value="送號" />
	</form>
	<br/>
	<a href="../.">返回首頁</a>
</body>
</html>