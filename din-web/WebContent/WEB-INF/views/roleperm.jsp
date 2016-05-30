<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<style type="text/css">
select {
	width: 200px;
	height: 100px;
}
</style>
<table>
	<form:form action="roleperm.htm" modelAttribute="role">
	<tr>
				<td align="left">id:</td>
				<td><form:input readonly="true" path="roleId"/></td>
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
		<tr>
			<td valign="middle" align="center">Select Permissions to add</td>
		</tr>
		<tr>
			<td colspan="2">
			<form:select path="permission" multiple="true"	items="${availablepermMap}" /></td>
			<td valign="middle" align="center">
			<input id="moveright" type="button" value="Move Right" onclick="move_list_items('permission','role');" /><br></br> 
			<input id="moveleft" type="button" value="Move Left" onclick="move_list_items('role','permission');" /></td>
			<td colspan="2"><form:select path="role" multiple="true" items="${selectpermMap}" /></td>
		</tr>
	</form:form>
</table>
