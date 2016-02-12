<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="resources/js/aa.js"></script>
<title>Insert title here</title>
</head>
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
<table>
		<form:form action="rolesList" modelAttribute="role">
			<tr>
				<td align="left">roles list</td>
				<td><form:select path="roleId" items="${rolesMap}" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>