<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}../css/style.css">
</head>
<body>
<div>
<h1 style="background-color:gray;display:inline-clock;padding:10px;color:white;">login
<span style="padding:10px;font-size:10px;color:black;" id="current_date">
<script>
date = new Date();
year = date.getFullYear();
month = date.getMonth() + 1;
day = date.getDate();
document.getElementById("current_date").innerHTML = year + "/" + month + "/" + day;
</script>
</span>
</h1>
</div>
</body>
</html>