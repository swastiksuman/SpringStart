<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="${pageContext.request.contextPath}/searchpage" commandName="offer" >
		<table class="formtable">
			<tbody>
				<tr><td>Name: </td><td><form:input class="control" path="name" type="text"></form:input></td></tr>
				<tr><td> </td><td><input class="control" value="Search" type="submit"></td></tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>