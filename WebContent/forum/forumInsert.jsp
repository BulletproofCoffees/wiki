<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script>
function insertforum(){
	document.formm.action = "WikiServlet?command=wiki_forum_Insert";
	document.formm.submit();
}
function cancelforum(){
	document.formm.action = "WikiServlet?command=wiki_forum";
	document.formm.submit();
}
</script>
<!-- <title>기본틀</title> -->
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
<div class="col-12">	
<!-- ---------------------------------------------- -->
<form name="formm" action="" method="post">

<table>
<tr>
<td>토론주제</td><td><input type="text" size="63px" name="title"></td>
</tr>
<tr>
<td>내용</td><td><textarea rows="10" cols="65px" name="text"></textarea></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="button" value="확인" onclick="insertforum()"> <input type="button" value="취소" onclick="cancelforum()"></td>
</tr>
</table>






</form>
<!-- --------------------------------------------------- -->
</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>