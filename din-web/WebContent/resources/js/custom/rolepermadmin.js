
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
    url: "roledata.htm",
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
    	debugger;
    	$('#roleId').val(json.roleData.roleId);
    	$('#name').val(json.roleData.name);
    	$('#externalName').val(json.roleData.externalName);
    	$('#description').val(json.roleData.description);
    	
    	var $el = $("#avpermselect");
    	$el.empty(); // remove old options
    	$.each(json.availablePerm, function(value,key) {
    	  $el.append($("<option></option>")
    	     .attr("value", value).text(key));
    	});
    	
    	
    	//var parArray=$.parseJSON(json.selectedperm);
    	
    	var $el = $("#selectedroleperm");
    	$el.empty(); // remove old options
    	$.each(json.selectedperm, function(index,value) {
    		console.log( index+"JSON Data: " + value );
    	  $el.append($("<option></option>")
    	     .attr("value", index).text(value));
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
