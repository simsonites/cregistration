   
     <script type="text/javascript">    
    	//select all checkboxes
    	$("#checkall").change(function(){  //"select all" change 
    	    var status = this.checked; // "select all" checked status
    	    $('.checkbox').each(function(){ //iterate all listed checkbox items
    	        this.checked = status; //change ".checkbox" checked status
    	    });
    	});

    	$('.checkbox').change(function(){ //".checkbox" change 
    	    //uncheck "select all", if one of the listed checkbox item is unchecked
    	    if(this.checked == false){ //if this item is unchecked
    	        $("#checkall")[0].checked = false; //change "select all" checked status to false
    	    }
    	    
    	    //check "select all" if all checkbox items are checked
    	    if ($('.checkbox:checked').length == $('.checkbox').length ){ 
    	        $("#checkall")[0].checked = true; //change "select all" checked status to true
    	    }
    	});
     </script>
     
      