<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script>
function wikiUpdateform() {
	document.formm.action = "WikiServlet?command=wikiUpdate_form";
	document.formm.submit();
}
</script>

</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 wikiDetail">
<div class="col-12">	
		
<!-- ---------------------------------------------- -->

<form name="formm" action="" method="post">
<input type="hidden" name="img" value = "${wikiVO.image}">
	<input type="hidden" name="wseq" value="${wikiVO.wseq}" size="2"/>
	<input type="button" onclick="wikiUpdateform()" value="글수정"  class="detailbutton">
	<div style="padding: 25px;">
	<h1>${wikiVO.title}</h1>
	
		<div >
			<p>${wikiVO.content}</p>
			</div>	 	
	</div>
	</form>
	
<!-- --------------------------------------------------- -->
</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>