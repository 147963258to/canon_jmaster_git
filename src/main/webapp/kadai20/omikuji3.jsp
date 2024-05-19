<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ</title>
</head>


<body>
<h1>Step3</h1>
<%
Random random = new Random();
// コンピュータは1～3のランダムな数値を取得する

int com = random.nextInt(6) + 1;
String result = "";


switch (com) {
case 1:
	result = "大吉";
  break;
case 2:
	result = "小吉";
  break;
case 3:
	result = "凶";
  break;
default:
	result = "吉";
  break;
}

String name = request.getParameter("NAME");
%>

<%=name %>さんの今日の運勢は、、、「<%=result %>」です。
</body>
</html>