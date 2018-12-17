<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 

<script>


window.onload = $(document).ready(function(){
	 $("#b").hide(); 
     $("#a").hide();
    $("#hide").click(function(){
         $("#b").hide(); 
         $("#a").show();
    });
    $("#show").click(function(){
        $("#b").show();
        $("#a").hide(); 
    });
});
</script>
</head>
<body>


<button id="hide">¼û±è</button>
<button id="show">º¸±â</button>

<div id="b">If you click on the "Hide" button, I will disappear.</div>
<div id="a">ddddddddddddddddddddddddddddddddddddddd</div>


</body>
</html>
