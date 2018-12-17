<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script><!-- 펼치기 제이쿼리  -->
<script> 
////////////////////////////////////////////////////////
$(document).ready(function(){
    $("#spreadBtn").click(function(){
        if($("#hiddenList").is(":visible")){
            $("#hiddenList").slideUp();
        }else{
            $("#hiddenList").slideDown();
        }
    });
});
//변환///////////////////////////////////////////////////
 function h1() {          
	   document.getElementById("title").onkeyup=Text;	
	   function Text() {
	      var txtBox = document.getElementById("title");
	      var lines = txtBox.value.split("\n");

	      var resultString  = "";
	      for (var i = 0; i < lines.length; i++) {
	        resultString += "<h1>"+lines[i] + "</h1>";
	      }	      
	      var blk = document.getElementById("result");
	      blk.innerHTML  = resultString;
	      
	      var Box = document.getElementById("title");
	      var aString = Box.value;	     
	      var b = document.getElementById("aa");
	      b.value = aString;
	     }
 }
	//변환////////////////////////////////////////////////////////////////////////////
	function calculationtest() {
		document.getElementById("content1").onkeyup = processText;//택스트 처리					
		function processText() {
			var txtBox = document.getElementById("content1");
			var lines = txtBox.value.replace(/(?:\r\n|\r|\n)/g,
					'<br />');
			var resultString = "<p>";
			for (var i = 0; i < lines.length; i++) {
				resultString += lines[i];
			}
			resultString += "</p>";
			var blk = document.getElementById("result2");
			blk.innerHTML = resultString;
			var blk2 = document.getElementById("conversion");
			blk2.value = resultString;
		}
	}
	////////////////////////////////////////////
	function s() {
    var target = document.getElementById("s");
    var gg = target.options[target.selectedIndex].value;
    var b = document.getElementById("dd");
    b.value = gg;
   }  
</script>
<!-- <title>기본틀</title> -->
</head>
<body>
<div class="col-1 ">
</div>
<div class="row">
<div class="col-8 wikiDetail">
<!-- ---------------------------------------------- -->    
			<div class="col-5">
				<div>
				
				
				
				
				
								
				분류<select name="option" id ="s" onclick="s()">
					<c:forEach items="${kindList}" var="kind" varStatus="status">
						<option value="${kind}">${kind}</option>
					</c:forEach>
					</select>
				</div>
				<div>제목 <input type="text" size="30" id='title' onkeyup="h1()"value="${search}"></div>

				<script>					
					var button = [
							"'<h1><span id=  > </span>      </h1>'",
							"'<h2><span id=  > </span>      </h2>'",
							"'<ul><li><a href=#  ><span>1</span></a>     </li>'",
							"'<li><a href=#  ><span>1</span></a>     </li>'",
							"'<li><a href=# ><span>2</span></a>    </li></ul>'",
							"'<a href=#  >      </a>'",
							"'<p> </p>'"
							];
					var key1 = [ 
						"<h1>",
						"<h2>", 
						"<ul><li>", 
						"<li></li>",
						"</li></ul>",
						"<a>", 
						"<p>" 
						];
					var keyout = "";
				
					keyout += '<div style="padding-bottom: 10px;padding-top: 10px;">';
					for (var i = 0; i < button.length; i++) {
						keyout += '<input type="button" value="';
						keyout += key1[i];
						keyout += '" onclick="kinput(';
						keyout += button[i];
						keyout += ')" class="button1" id="';
						keyout += button[i];
						keyout += '">';
					}
					keyout += '</div>';

					keyout += '<div><textarea id ="content1" class="col-5 textbox"onKeyUp="calculationtest()" ></textarea></div>' //텍스트박스
					
					document.write(keyout);
					var textbox = document.getElementById("content1");
					var textinput = "";
					function kinput(b) {
						textbox.value += String(b);
					}				
				</script>
				
                <div >
				<button id="spreadBtn"  style="float: left; " class="button1">htML 문서</button>				
				<form action="WikiServlet?command=wikiInsert" method="post" name="formm">
					<input type="submit" type=button value='저장' style="float: left;" class="button1">
					<div id="hiddenList" style="display: none;">
					<div><input name="kind" type="text" id="dd" ></div>
					<div><input type="text" size="30" name="title" id='aa' onkeyup="h1()"></div>
						<textarea rows="9" cols="50" name="content" id="conversion"
						class="textbox2" onKeyUp="calculationtest()" readonly></textarea>
					</div>
				</form>				
				</div>
				</div>			
			<div>
		<div class="col-6" style="border-left: 1px solid #777777;width:50%; height:800px; overflow:scroll;padding-top: 5%;">			
					출력
					<div id="result"></div>
					<div id="result2"></div>					
				</div>	
				</div>		
<!-- --------------------------------------------------- -->
</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>