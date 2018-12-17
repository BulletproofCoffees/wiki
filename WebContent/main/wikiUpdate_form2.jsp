<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script><!-- 펼치기 제이쿼리  -->
<script>
$(document).ready(function(){
    $("#spreadBtn").click(function(){
        if($("#hiddenList").is(":visible")){
            $("#hiddenList").slideUp();
        }else{
            $("#hiddenList").slideDown();
        }
    });
});
/////////////////////////////////////////////////////
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
window.onload = function(){
	var txtBox = document.getElementById("conversion");
	var lines = txtBox.value.split("<br />");
	var resultString = "";
	for (var i = 0; i < lines.length; i++) {
		resultString += lines[i] + "\n";
	}
	 var blk = document.getElementById("content1");
	 blk.innerHTML = resultString;			
}
function a() {	
		var txtBox = document.getElementById("content1");
		 var lines = txtBox.value.split("\n");
		    var sString  = "";
		    for (var i = 0; i < lines.length; i++) {
		      sString += lines[i] + "<br />";
		    }
		var blk3 = document.getElementById("conversion");
		blk3.value = sString;
		var blk2 = document.getElementById("result2");
		blk2.innerHTML = sString;
}
function b() {	  	
		var txtBox = document.getElementById("conversion");
		var lines = txtBox.value.split("<br />");
		var String = "";
		for (var i = 0; i < lines.length; i++) {
			String += lines[i] + "\n";
		}
		 var blk = document.getElementById("content1");
		 blk.value = String;
	
}

 function s() {
	    var target = document.getElementById("s");
	    var gg = target.options[target.selectedIndex].value;
	    var b = document.getElementById("dd");
	    b.value = gg;
	   } 
 
 function wikiUpdate() {
		document.formm.action = "WikiServlet?command=wikiUpdate";
		document.formm.submit();
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
			문서 수정
				<div>분류
				<select id ="s" onclick="s()">
				<c:forEach items="${kindList}" var="kind" varStatus="status">
						<option value="${kind}">${kind}</option>
					</c:forEach>
					</select>
					</div>
				<div><input type="text" size="30" id='title' onkeyup="h1()" value="${wikiVO.title}"></div>				
				<div><textarea class="col-12 textbox" id="content1"   onkeyup="a()">${wikiVO.content}</textarea></div>	
						
		<div>				
		<div>
		<button id="spreadBtn"  style="float: left; " class="button1">htML 문서</button>
		<!-- 저장값 --------------------------------------------------------------------------------------------------------------------------------------->
		<form name="formm" method="post" enctype="multipart/form-data">
		<div><input type="button" onclick="wikiUpdate()" value="수정" class="button1"></div>
		<div id="hiddenList" style="display: none;">
		<div><input type="hidden" name="wseq" value="${wikiVO.wseq}" size="2"/></div>
		<div><input name="kind" type="text" id="dd" value="${wikiVO.kind}"></div>		
		<div><input type="text" size="30" name="title" id='aa' onkeyup="h1()"value="${wikiVO.title}"></div>
		<div><textarea name="content" id="conversion" class="col-5 textbox2" readonly onkeyup="b()">${wikiVO.content}</textarea></div>								
		</div>
		</form>
		<!-- --------------------------------------------------------------------------------------------------------------------------------------------- -->
		</div>
		</div>		
			</div>			
			<div class="col-6" style="border-left: 1px solid #777777;width:50%; height:800px; overflow:scroll;padding-top: 5%;">	
				출력
				<div id="result"><h1>${wikiVO.title}</h1></div>
				<div id="result2">${wikiVO.content}</div>
			</div>
		
		<!-- --------------------------------------------------- -->
</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>