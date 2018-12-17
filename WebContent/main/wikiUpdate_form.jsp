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
<h3>문서 수정</h3> 
<form action="WikiServlet?command=wikiUpdate" method="post" name="formm">
<input type="hidden" name="wseq" value="${wikiVO.wseq}"/>
	<input type="text" size="30" value="${wikiVO.title}" class="title" readonly>
	<div><textarea name="content" id="summernote">${wikiVO.content}</textarea></div>		
 <input type="submit" type=button value="글수정하기"style="float: left;" class="button1">
</form>
<!-- ---------------------------------------ㅊ------------ -->
</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>