<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/docreate">
<table>
	<tr><td>Name: </td><td><input name="name1" type="text"></td></tr>
	<tr><td>Email: </td><td><input name="email" type="text"></td></tr>
	<tr><td>Your Offer: </td><td><textarea name="text" rows="10" cols="50"></textarea></td></tr>
	<tr><td> </td><td><input value="Create Ad" type="submit"></td></tr>
</table>
</form>
</body>
</html>