<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${contextDataBean.jqueryJsPath}"></script>
<script type="text/javascript" src="resources/js/aa.js"></script>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<title>Insert title here</title>
</head>
<script>
function allSelected()
{
	alert('d');
    $("#selectedroleperm").find("option").each(function() {
    $(this).attr('selected', 'selected');
    }); 
}

function select(){
var idValue = $( "#roleList" ).val();
populateValues(idValue);
//$('#stage').load('/din-web/roleperm?roleId='+idValue);
}

function populateValues(idValue){
//Using the core $.ajax() method
$.ajax({
    // The URL for the request
    url: "roledata",
    // The data to send (will be converted to a query string)
    data: {
    	roleId: idValue
    },
    // Whether this is a POST or GET request
    type: "GET",
    // The type of data we expect back
    dataType : "json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function( json ) {
    	
    	$('#roleId').val(json.rolePerm.role.roleId);
    	$('#name').val(json.rolePerm.role.name);
    	$('#externalName').val(json.rolePerm.role.externalName);
    	$('#description').val(json.rolePerm.role.description);
    	
    	var $el = $("#avpermselect");
    	$el.empty(); // remove old options
    	$.each(json.availablePerm, function(value,key) {
    	  $el.append($("<option></option>")
    	     .attr("value", key.permId).text(key.name));
    	});
    	
    	
    	//var parArray=$.parseJSON(json.selectedperm);
    	
    	var $el = $("#selectedroleperm");
    	$el.empty(); // remove old options
    	$.each(json.selectedperm, function(index,value) {
    		console.log( index+"JSON Data: " + value.name );
    	  $el.append($("<option></option>")
    	     .attr("value", value.permId).text(value.name));
    	});
        //$( "<h1>" ).text( json.title ).appendTo( "body" );
        //$( "<div class=\"content\">").html( json.html ).appendTo( "body" );
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
    // Code to run regardless of success or failure
    complete: function( xhr, status ) {
        //alert( "The request is complete!" );
    }
    
});
}
</script>
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
		<form:form action="saverole" modelAttribute="role">
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
			<td ><form:select path="permissionList" multiple="true" items="${selectedPerm}"  id="selectedroleperm" style="height: 201px; width: 200px;" /></td>
		</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save" onclick="allSelected()">
				</td>
			</tr>		
			
			
			
			
			
			
		</form:form>
	</table>
	
		
</body>
</html>