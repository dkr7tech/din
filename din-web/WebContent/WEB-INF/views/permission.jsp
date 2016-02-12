<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h1>Permission</h1>
		<table>
			<form:form action="saveperm" method="post" modelAttribute="permission">
			<%-- <form:hidden path="id"/> --%>
			<tr>
				<td align="left">id:</td>
				<td><form:input path="permId"/></td>
			</tr>
			<tr>
				<td align="left">Role Name:</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td align="left">description</td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
</body>
</html>