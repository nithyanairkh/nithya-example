<%@include file="/libs/foundation/global.jsp"%>
<cq:include script="/libs/wcm/core/components/init/init.jsp"/>



<! DOCTYPE html>

<html>
<head>

    <cq:includeClientLib categories="apps.aem.nithya" />


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script> -->
<script> 
$(document).ready(function(){
	$("button").click(function(){
        $.ajax({

            url:"/bin/service/mine",
            type:"POST",
            data:"name1="+$("#name1").val()+"&age="+$("#age").val(),
            success:function(result){
            $("#nithya").html(result);

           },
               error: function(xhr, textStatus, error) {

            $("form").hide();
            $("#nithya").html("<h2>"+xhr.statusText+"</h2>");
   					console.log(xhr.statusText);
      console.log(textStatus);
      console.log(error);
 			 }

       });



    });

});










</script>

 </head>

 <body>

<cq:include path ="bdcomp" resourceType ="/apps/nithyanew/components/breadcrumb" />
     <cq:include path="comp" resourceType = "/apps/nithyanew/components/fullcomponent" />
     <cq:include path="carcomp" resourceType="/apps/nithyanew/components/carousel"/>

     <!-- properties.relParent,properties.delim,properties.trail -->


<form action = "/bin/service/mine"> 

    Enter your Name <input type = "text" name= "name1" id="name1" />
    Enter your Age <input type = "text" name= "age" id ="age" />

    <input type ="submit" value="Enter" />
<button> Click </button> <br>


</form>


<div id="nithya"></div>


<cq:include path="par" resourceType="/libs/foundation/components/parsys"/>
<cq:include path="ipar" resourceType="/libs/foundation/components/parsys"/>

 </body>

</html>