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
    <%@ include file="../include/header.jsp" %>
<div align="center">
		<h1>Create Role</h1>
		<table>
			<form:form action="saverole.htm" method="post" modelAttribute="role">
			<%-- <form:hidden path="id"/> --%>
		
			<tr>
				<td align="left">id:</td>
				<td><form:input path="roleId"/></td>
			</tr>
			<tr>
				<td align="left">Role Name:</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td align="left">External Name:</td>
				<td><form:input path="externalName"/></td>
			</tr>
			<tr>
				<td align="left">description</td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td align="left">public</td>
				<td>public</td>
			</tr>
			<tr>
				<td align="left">type</td>
				<td><form:input path="type"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	<%@ include file="../include/footer.jsp" %>
</body>
</html>