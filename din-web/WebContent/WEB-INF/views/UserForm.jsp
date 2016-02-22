<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>New or Edit User</title>
</head>
<script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>
<script>   
    /*
		@param1 - sourceid - This is the id of the multiple select box whose item has to be moved.
		@param2 - destinationid - This is the id of the multiple select box to where the iterms should be moved.
	*/
	
	//this will move selected items from source list to destination list			
	function move_list_items(sourceid, destinationid)
	{
		$("#"+sourceid+"  option:selected").appendTo("#"+destinationid);
	}

	//this will move all selected items from source list to destination list
	function move_list_items_all(sourceid, destinationid)
	{
		$("#"+sourceid+" option").appendTo("#"+destinationid);
	}
</script>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="save" method="post" modelAttribute="userrole">
		<table>
			
			<%-- <form:hidden path="id"/> --%>
			<tr>
				<td align="left">Gender:</td>
				<td><form:input path="user.gender"/></td>
			</tr>
			<tr>
				<td align="left">User Name:</td>
				<td><form:input path="user.login"/></td>
			</tr>
			<tr>
				<td align="left">First Name:</td>
				<td><form:input path="user.firstName"/></td>
			</tr>
			<tr>
				<td align="left">Middle Name:</td>
				<td><form:input path="user.middleName"/></td>
			</tr>
			<tr>
				<td align="left">Last Name:</td>
				<td><form:input path="user.lastName"/></td>
			</tr>
			<tr>
				<td align="left">Date of birth:(dd/mm/yyyy)</td>
				<td><form:input path="user.dob"/></td>
			</tr>
		    <tr>
				<td align="left">Email:</td>
				<td><form:input path="user.email"/></td>
			</tr>
			<tr>
				<td align="left">Password:</td>
				<td><form:password path="user.password"/></td>
			</tr>
			<tr  align="center">
			<td >
			<form:select  path="role" multiple="true"	items="${availableRoles}" id="avpermselect" style="height: 201px; width: 200px;" /></td>
			<td valign="middle" align="center">
			<input id="moveright" type="button" value="Move Right" onclick="move_list_items('avpermselect','selectedroleperm');" /><br></br> 
			<input id="moveleft" type="button" value="Move Left" onclick="move_list_items('selectedroleperm','avpermselect');" /></td>
			<td ><form:select path="user" multiple="true" items="${selectedRoles}"  id="selectedroleperm" style="height: 201px; width: 200px;"/></td>
		</tr>	
			<%-- <tr><td align="left">Assign Roles</td>
			<%@ include file="userdata.jsp" %>
			</tr> --%>
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