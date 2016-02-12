<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>New or Edit User</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="save" method="post" modelAttribute="user">
		<table>
			
			<%-- <form:hidden path="id"/> --%>
			<tr>
				<td align="left">Gender:</td>
				<td><form:input path="gender"/></td>
			</tr>
			<tr>
				<td align="left">User Name:</td>
				<td><form:input path="login"/></td>
			</tr>
			<tr>
				<td align="left">First Name:</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td align="left">Middle Name:</td>
				<td><form:input path="middleName"/></td>
			</tr>
			<tr>
				<td align="left">Last Name:</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td align="left">Date of birth:(dd/mm/yyyy)</td>
				<td><form:input path="dob"/></td>
			</tr>
		    <tr>
				<td align="left">Email:</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td align="left">Password:</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr><td align="left">Assign Roles</td>
			<%@ include file="userdata.jsp" %>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			
		</table>
		</form:form>
	</div>
	
</body>
</html>