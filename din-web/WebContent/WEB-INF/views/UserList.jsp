<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    <%@ include file="../include/header.jsp" %>
        <div align="center">
	        <h1>Users List</h1>
	        <table border="1">
	        	<th>No</th>
	        	<th>Username</th>
	        	<th>Email</th>
	        	<th>Actions</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${user.login}</td>
					<td>${user.email}</td>
					<td>
						<a href="edit.htm?id=${user.userId}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete.htm?id=${user.userId}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
