<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Language Identification Service</title>

<style type="text/css">
.even {
	background-color: silver;
}
</style>
</head>
<body>
	<form:form method="POST" action="/app/identify">
		<table>
			<tr>
				<td align="right">Your Input :</td>
				<td align="left"><form:textarea path="text"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>