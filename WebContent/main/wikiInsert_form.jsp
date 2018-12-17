<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/Baes/summernote.jsp" %>
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">

	
<div class="col-7 wikiDetail">
<!-- ---------------------------------------------- -->   
<h3>새 문서 생성</h3> 
<form action="WikiServlet?command=wikiInsert" method="post" name="formm">
	<input type="text" size="30" value="${search}"name="title" class="title" readonly>
	<div><textarea name="content" id="summernote"><p>Hello Summernote</p></textarea></div>		
<input type="submit" type=button value='저장' style="float: left;" class="button1">
</form>
<!-- ---------------------------------------ㅊ------------ -->
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>