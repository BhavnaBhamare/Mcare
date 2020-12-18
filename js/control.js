/*Without jQuery Cookie*/
$(document).ready(function(){
	$("#parent1").css("display","none");
            
    $(".aboveage1").click(function(){
    	if ($('input[name=age1]:checked').val() == "No" ) {
        	$("#parent1").slideDown("fast"); //Slide Down Effect   
        } else {
            $("#parent1").slideUp("fast");	//Slide Up Effect
        }
     });            
});

/*With jQuery Cookie*/
$(document).ready(function(){
	$("#parent2").css("display","none");
            
    $(".aboveage2").click(function(){
    	if ($('input[name=age2]:checked').val() == "No" ) {
        	$("#parent2").slideDown("fast"); //Slide Down Effect
            $.cookie('showTop', 'expanded');              
        } else {
            $("#parent2").slideUp("fast");	//Slide Up Effect
            $.cookie('showTop', 'collapsed');
        }
     });  
     
      var showTop = $.cookie('showTop');  
     
      if (showTop == 'expanded') {  
		
      	$("#parent2").show("fast");  
        $('input[name=age2]:checked');  

      } else {
      	$("#parent2").hide("fast");
        $('input[name=age2]:checked');
      }  
          
});