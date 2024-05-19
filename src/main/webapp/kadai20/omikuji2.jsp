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
<h1>Step1</h1>
<%
Random random = new Random();
// コンピュータは1～3のランダムな数値を取得する

for (int i = 1;i<=12 ; i++){
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
%>

<%=i %>月の運勢は、、、「<%=result %>」です。<br>
<% }%>
</body>
</html>