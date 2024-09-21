<%@page import="org.eclipse.tags.shaded.org.apache.xpath.operations.Bool"%>
<%@page import="java.util.LinkedList"%>
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
	<h2>猜數字遊戲</h2>
	<h3>Guess 1~${ range }</h3>
	<ul style="color: red; font-size: 0.8em">
		<table style="margin:auto">
			<%
				LinkedList<String> errorMsgs = (LinkedList)request.getAttribute("errorMsgs");
				if(errorMsgs != null) {
					for(String errorMsg : errorMsgs) {
						out.println("<tr><td><li>" + errorMsg + "</li></td></tr>");
					}
				}
			%>
		</table>
	</ul>
	<form action="gameController.do" method="post">
		<table style="margin:auto">
			<tr>
				<td><input type="text" placeholder="請輸入整數" name="number" /></td>
				<td><input type="submit" value="Guess" /></td>
			</tr>
		</table>
	</form>
	<p>剩餘${ guessGame.getRemains() }次機會</p>
	<p>答題記錄: ${ guessGame.getRecordNumber() }</p>
	<% 
		boolean isSecret = (boolean)session.getAttribute("answer");
		if(isSecret) {
	%>
	<p>答案: ${ guessGame.getLuckyNumber() }</p>
	<%	} %>
	<a href="../.">返回首頁</a>
</body>
</html>