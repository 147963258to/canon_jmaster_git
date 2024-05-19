<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>


<%
	List<String> list = new ArrayList<>();
	String action = request.getParameter("ACTION");
	
// 	セッションを開始する
// 	ユーザーを一意に識別する
// 	ユーザーごとのデータをセッション変数に格納する
// 	同一セッション内の異なるページで、セッション変数として格納されているデータを取得する
// 	セッションを破棄する


	if("write".equals(action)){
		//セッションがNULLでなければ、取得してリストに入れる
		if (session.getAttribute("sessionList") != null){
		list = (List<String>) session.getAttribute("sessionList");
		}
		//送信データを取得
		String name = request.getParameter("NAME");
		String message = request.getParameter("MESSAGE");

		//リストに入れる
		list.add(name + ":" + message);
	
		//セッションに保存
		session.setAttribute("sessionList", list);
	}

%>


	<form action="" method="post">
		<input type="hidden" name="ACTION" value="write">
		名前：<br>
		<input type="text" name="NAME">
		<br>
		メッセージ：<br>
		<textarea name="MESSAGE" cols="30" rows="5"></textarea>
		<br>
		<input type="submit" value="書き込み">
	</form>
	<hr>
	
<% 	for (String l : list) {%>

		<%=l %>
		<hr>
<%		}%>
	
	
</body>
</html>