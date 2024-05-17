<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初めてのJSP</title>
</head>
<body>


<%! public int tasu(int x,int y){
	return x + y;
	
} %>>



<%--スクリプトレット　javaのプログラムを書くところ --%>>


<% 
//名前
out.println("山田太郎" + "<br>");


for (int i = 1; i<= 5; i++){
	out.println("for山田太郎" + "<br>"")
}
%>>


</body>
</html>