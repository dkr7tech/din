<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>


<script type="text/javascript" src="${contextData.customJsPath}/rolepermadmin.js"></script>
<title>Role Permission Administration</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<table>
		<form:form action="saverole.htm" modelAttribute="role">
			<tr>
				<td align="left">roles list</td>
				<td><form:select id="roleList" path="roleId"  onchange="select()">
				<form:option value="0" label="--Please Select" selected="selected"/>
			<form:options items="${rolesMap}" itemValue="IdAsString" itemLabel="Name"  />
			</form:select>
				</td>
			</tr>
			<td align="left">id:</td>
				<td><form:input readonly="true" path="roleId" id="roleId"/></td>
			</tr>
			<td align="left">Active:</td>
				<td><form:input readonly="true" path="status" id="status"/></td>
			</tr>
			<tr>
				<td align="left">Role Name:</td>
				<td><form:input path="name" id="name"/></td>
			</tr>
			<tr>
				<td align="left">External Name:</td>
				<td><form:input path="externalName" id="externalName" /></td>
			</tr>
			<tr>
				<td align="left">description</td>
				<td><form:input path="description" id="description"/></td>
			</tr>
			<tr>
				<td align="left">public</td>
				<td>public</td>
			</tr>
			<tr>
				<td align="left">type</td>
				<td><form:input path="type"/></td>
			<tr  align="center">
			<td >
			<form:select  path="" multiple="true"	items="${availablePerm}" id="avpermselect" style="height: 201px; width: 200px;" /></td>
			<td valign="middle" align="center">
			<input id="moveright" type="button" value="Move Right" onclick="move_list_items('avpermselect','selectedroleperm');" /><br></br> 
			<input id="moveleft" type="button" value="Move Left" onclick="move_list_items('selectedroleperm','avpermselect');" /></td>
			<!--if you change path properties then change in initBinder -->
			<td ><form:select path="permissionList" multiple="true" items="${selectedPerm}"  id="selectedroleperm" style="height: 201px; width: 200px;" /></td>
		</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save" onclick="allSelected()">
				</td>
			</tr>		
			
			
			
			
			
			
		</form:form>
	</table>
	
	<%@ include file="../include/footer.jsp" %>
		
</body>
</html>