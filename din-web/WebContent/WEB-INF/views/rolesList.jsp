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
    	json.availablePerm
    	var $el = $("#avselect");
    	$el.empty(); // remove old options
    	$.each(json.availablePerm, function(value,key) {
    	  $el.append($("<option></option>")
    	     .attr("value", value).text(key));
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
<table>
		<form:form action="rolesList" modelAttribute="rolePerm">
			<tr>
				<td align="left">roles list</td>
				<td><form:select id="roleList" path="role.roleId" items="${rolesMap}" onchange="select()"/></td>
			</tr>
			<td align="left">id:</td>
				<td><form:input readonly="true" path="role.roleId" id="roleId"/></td>
			</tr>
			<tr>
				<td align="left">Role Name:</td>
				<td><form:input path="role.name" id="name"/></td>
			</tr>
			<tr>
				<td align="left">External Name:</td>
				<td><form:input path="role.externalName" id="externalName" /></td>
			</tr>
			<tr>
				<td align="left">description</td>
				<td><form:input path="role.description" id="description"/></td>
			</tr>
			<tr>
				<td align="left">public</td>
				<td>public</td>
			</tr>
			<tr>
				<td align="left">type</td>
				<td><form:input path="role.type"/></td>
			</tr>
			<tr><td>
			<form:select  path="permission" multiple="true"	items="${availablePerm}" id="avselect" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
		</form:form>
	</table>
	 <div id = "stage" style = "background-color:cc0;">
         STAGE
      </div>
		
</body>
</html>