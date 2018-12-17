<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script>
function h1() {          
   document.getElementById("박스2").onkeyup=Text;
   function Text() {
      var txtBox = document.getElementById("박스2");
      var lines = txtBox.value.split("\n");   
      var resultString  = "<p>";
      for (var i = 0; i < lines.length; i++) {
        resultString += "<h1>"+lines[i] + "</h1>";
      }
      resultString += "</p>";          
      var blk2 = document.getElementById("re");
      blk2.innerHTML  = resultString; 
      
      
      var Box = document.getElementById("박스2");
      var aString = Box.value;
      var blk = document.getElementById("result");
      blk.value  = aString;
     }  
}



function a() {
    document.getElementById("박스").onkeyup=processText;//택스트 처리   
   function processText() {
    var txtBox = document.getElementById("박스");
    var lines = txtBox.value.split("\n");
    var resultString  = "<p>";
    for (var i = 0; i < lines.length; i++) {
      resultString += lines[i] + "<br />";
    }
    resultString += "</p>";
    var blk = document.getElementById("result2");
    blk.innerHTML  =  resultString; 
    var blk2 = document.getElementById("re2");
    blk2.innerHTML  =  resultString; 
   }  
}

function s() {
    var target = document.getElementById("s");
    var gg = target.options[target.selectedIndex].text;
    var b = document.getElementById("aa");
    b.value = gg;
   }  
   
window.onload = function() {
	  alert(<%System.out.println(request.getParameter("title"));%>);
	}

</script>
<!-- <title>기본틀</title> -->
</head>
<body>


<!-- ---------------------------------------------- -->

<div style="float: left;">

                    <select name="kind" id ="s" onclick="s()">					
						<option>1</option>
						<option>2</option>					
					</select>
 <div>
 <input type="text" id='박스2' size="20px" onkeyup="h1()"></div>
 <textarea id="박스" cols="20" rows="10" onkeyup="a()">테스트 테스트</textarea> 
 </div>
 
<form action ="WikiServlet?command=wikiUpdate2" method="post" name="formm">
<!-- <div><input type="text" id="aa" name="title" ></div> -->
<div><input type="text" id="result" name="title" ></div>
<textarea id="result2" cols="20" rows="10" name="content" ></textarea>
<div><input type="submit" type=button value='저장' ></div>
</form> 
<div id="re"></div>
<div id="re2"></div>
<!-- --------------------------------------------------- -->
</body>
</html>