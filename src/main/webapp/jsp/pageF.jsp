<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
<%
request.setAttribute("data", 10);
request.setAttribute("data2", "");
%>

${data > 0}<br>

${data gt 0}<br>
${empty data2}<br>
</body>
</html>