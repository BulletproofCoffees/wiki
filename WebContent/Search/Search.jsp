<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script>
function a(){
	document.formm.action = "WikiServlet?command=wikiInsert_form";
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
<div  style="text-align:right"><a href="WikiServlet?command=wikiInsert_form">[${search}문서 만들기]</a></div>
</form>
<div  > </div>
<div>${search} 문서가 없습니다!<br />  </div>
<div>연관 검색어</div>
		<c:forEach var="wikiVO" items="${wikiList}">
		<table>   
				<tr>
					<td style="width: 500px;"><a href="WikiServlet?command=wikiDetail&wseq=${wikiVO.wseq}" class="col-12">${wikiVO.title}</a></td>			
				    <td style="width: 100px;"><fmt:formatDate value="${wikiVO.indate}"/></td>
				</tr>
				</table>			
		</c:forEach>

<!-- --------------------------------------------------- -->
</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>