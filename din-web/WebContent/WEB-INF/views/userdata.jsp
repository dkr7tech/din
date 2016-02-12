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
	width:200px;
	height:100px;
}
</style>



    <td colspan="2">
        <select id="from_select_list" multiple="multiple" name="from_select_list"> 
        <option value="apple">Apple</option><option value="mango">Mango</option> <option value="bannana">Bannana</option> <option value="grapes">Grapes</option> 
        </select>
    </td>
     <td valign="middle" align="center">
			 <input id="moveright" type="button" value="Move Right" onclick="move_list_items('from_select_list','to_select_list');" /><br></br>
			<input id="moveleft" type="button" value="Move Left" onclick="move_list_items('to_select_list','from_select_list');" /> 
		</td>
    <td colspan="2">
        <select id="to_select_list" multiple="multiple" name="to_select_list"> 
        <option value="winder">Winter</option> <option value="summer">Summer</option> <option value="rainy">Rainy</option> <option value="Spring">Spring</option> 
        </select>
    </td>



<!-- <tr>

    <td><input id="moveright" type="button" value="Move Right" onclick="move_list_items('from_select_list','to_select_list');" /></td>
    
    <td><input id="moverightall" type="button" value="Move Right All" onclick="move_list_items_all('from_select_list','to_select_list');" /></td>
    
    <td><input id="moveleft" type="button" value="Move Left" onclick="move_list_items('to_select_list','from_select_list');" /></td>
    
    <td><input id="moveleftall" type="button" value="Move Left All" onclick="move_list_items_all('to_select_list','from_select_list');" /></td>

</tr> -->


