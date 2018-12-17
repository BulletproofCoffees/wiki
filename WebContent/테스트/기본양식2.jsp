<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function a() {
	document.getElementById("content1").onkeyup = processText;
	function processText() {
		var txtBox = document.getElementById("content1");
		 var lines = txtBox.value.split("\n");
		    var resultString  = "";
		    for (var i = 0; i < lines.length; i++) {
		      resultString += lines[i] + "<br />";
		    }
		var blk2 = document.getElementById("result2");
		blk2.innerHTML = resultString;
		var blk3 = document.getElementById("conversion");
		blk3.innerHTML = resultString;
	}
}
  function b() {	  
		document.getElementById("conversion").onkeyup = processText;
		function processText() {
			var txtBox = document.getElementById("conversion");
			var lines = txtBox.value.split("<br />");
			var resultString = "";
			for (var i = 0; i < lines.length; i++) {
				resultString += lines[i] + "\n";
			}
			 var blk = document.getElementById("content1");
			 blk.innerHTML = resultString;			
        
		}
	}
	
	
	
</script>

</head>
<body>
 <textarea  cols="20" rows="10" id="content1" onkeyup="a()"><h1>가져온값</h1><br />sss저장</textarea>
 <textarea id="conversion" cols="20" rows="10" onkeyup="b()">수정값</textarea>
  <div id="result2"></div>


</body>
</html>