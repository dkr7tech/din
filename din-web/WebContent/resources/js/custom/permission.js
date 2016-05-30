
function select(){
var idValue = $( "#permList" ).val();
populateValues(idValue);
//$('#stage').load('/din-web/roleperm?roleId='+idValue);
}

function populateValues(idValue){
//Using the core $.ajax() method
$.ajax({
    // The URL for the request
    url: "permdata.htm",
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
