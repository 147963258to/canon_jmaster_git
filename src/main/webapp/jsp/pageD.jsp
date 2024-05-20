<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
<%
String[] canon = {"椿","東海林","小川"};
request.setAttribute("canon", canon);

List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(30);
%>
${canon[0]}<br>
${canon[1]}<br>
${canon[2]}<br>
<hr>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>
<hr>
${hash["AAA"]}<br>
${hash.BBB}<br>


</body>
</html>