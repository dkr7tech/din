<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="../include/script/script.jsp" %>
<%@ include file="../include/jsplib/springlib.jsp" %>
<script type="text/javascript" src="${contextData.customJsPath}/permission.js"></script>
<title>Insert title here</title>

</head>
<body>
<div align="center">
		<h1>Permission</h1>
		<table>
			<form:form action="saveperm" method="post" modelAttribute="rolePerm">
			<%-- <form:hidden path="id"/> --%>
				<tr>
				<td align="left">Select Permission</td>
				<td><form:select id="permList" path="permission.permId" items="${permMap}" onchange="select()"/></td>
			</tr>
			<tr>
				<td align="left">id:</td>
				<td><form:input id="permId" path="permission.permId"/></td>
			</tr>
			<tr>
				<td align="left">Status:</td>
				<td><form:input id="status" path="permission.status"/></td>
			</tr>
			
			<tr>
				<td align="left">Role Name:</td>
				<td><form:input id="name" path="permission.name"/></td>
			</tr>
			<tr>
				<td align="left">description</td>
				<td><form:input id="description" path="permission.description"/></td>
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