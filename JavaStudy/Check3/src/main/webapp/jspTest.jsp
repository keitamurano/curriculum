<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- name、idの入力エリアを作成しなさい -->
<table>
<tr>
<td>
<p style="padding-top: 50px;">
<label for="name">name</label>
<input type="text" name="name" id=name>
</p>
</td>
</tr>

<tr>
<td>
<p style="padding-bottom: 50px;">
<label for="name2">id</label>
<input type="text" name="name" id=name2>
</p>
</td>
</tr>
</table>

<jsp:include page="footer.jsp"/>
</body>
</html>