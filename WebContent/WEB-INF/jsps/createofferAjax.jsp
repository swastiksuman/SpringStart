<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/main.css"
	rel="stylesheet" type="text/css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(
			function() {
				$('#sampleForm').submit(
						function(event) {
							var email = $('#email').val();
							var name = $('#name').val();
							var text - $('#text').val();
							var data = 'email='
									+ encodeURIComponent(email)
									+ '&name='
									+ encodeURIComponent(name)
									+ '&text='
									+ encodeURIComponent(text);
							$.ajax({
								url : $("#sampleForm").attr("action"),
								data : data,
								type : "POST",

								success : function(response) {
									alert(response);
								},
								error : function(xhr, status, error) {
									alert(xhr.responseText);
								}
							});
							return false;
						});
			});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

	<form id="sampleForm" method="post" action="/SpringStart/createofferajax">
		<table class="formtable">
			<tr>
				<td>Name:</td>
				<td><input id="name" class="control" type="text"></input><br />
			</tr>
			<tr>
				<td>Email:</td>
				<td><input id="email" class="control" type="text"></input></td>
			</tr>
			<tr>
				<td>Your Offer:</td>
				<td><textarea id="text" class="control" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><button name="control" type="submit">Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>