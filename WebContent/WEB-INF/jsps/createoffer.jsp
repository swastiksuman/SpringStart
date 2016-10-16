<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>


<form:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
<table class="formtable">
	<tr><td>Name: </td><td><form:input class="control" path="name" type="text"></form:input><br/><form:errors path="name" cssClass="error"></form:errors></td></tr>
	<tr><td>Email: </td><td><form:input class="control" path="email" type="text"></form:input></td></tr>
	<tr><td>Your Offer: </td><td><form:textarea class="control" path="text" rows="10" cols="50"></form:textarea></td></tr>
	<tr><td> </td><td><input class="control" value="Create Ad" type="submit"></td></tr>
</table>
</form:form>
</body>
</html>