<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script>
		 $(document).ready(function() {
			$('#content1').summernote();
		});	
		 
		 
		 function a() {			
					var txtBox = document.getElementById("content");
					  var lines = txtBox.value.split("\n");
					    var resultString  = "";
					    for (var i = 0; i < lines.length; i++) {
					      resultString += lines[i];
					    }
					var blk2 = document.getElementById("result2");
					blk2.innerHTML = resultString;									
			}
			
				 
	</script>	
</head>
<body>





<form action ="WikiServlet?command=wikiUpdate2" method="post" name="formm">
<textarea id="content1" name="title"> 
출처:http://zer0wiz.tistory.com/entry/Summernote-오픈소스-위지윅-에디터WYSIWYG-Editor
[Zero's Dev]</textarea>
<input type="submit" type=button value='저장' >
</form>




<textarea id="content" onkeyup="a()"></textarea>
<div id="result2" ></div>
 







	
</body>
</html>
