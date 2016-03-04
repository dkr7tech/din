<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="resources/js/aa.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>   
function select(){
var idValue = $( "#permList" ).val();
populateValues(idValue);
//$('#stage').load('/din-web/roleperm?roleId='+idValue);
}

function populateValues(idValue){
//Using the core $.ajax() method
$.ajax({
    // The URL for the request
    url: "permdata",
    // The data to send (will be converted to a query string)
    data: {
    	permId: idValue
    },
    // Whether this is a POST or GET request
    type: "GET",
    // The type of data we expect back
    dataType : "json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function( json ) {
    	
    	$('#permId').val(json.permission.permId);
    	$('#name').val(json.permission.name);
    	$('#status').val(json.permission.status);
    	$('#description').val(json.permission.description);
    	/* json.availablePerm
    	var $el = $("#avpermselect");
    	$el.empty(); // remove old options
    	$.each(json.availablePerm, function(value,key) {
    	  $el.append($("<option></option>")
    	     .attr("value", value).text(key));
    	});
    	
    	
    	
    	var $el = $("#selectedroleperm");
    	$el.empty(); // remove old options
    	$.each(json.selectedPerm, function(value,key) {
    	  $el.append($("<option></option>")
    	     .attr("value", value).text(key));
    	}); */
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