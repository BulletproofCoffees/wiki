<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function search() {
	document.formm.action = "WikiServlet?command=wikiList";
	document.formm.submit();
}
function wikiadd() {
	document.formm.action = "WikiServlet?command=wikiInsert_form"; 
	document.formm.submit();
}
function click1() { 
	document.formm.action = "WikiServlet?command=wikiListH";
	document.formm.submit();
}
function click2() {
	document.formm.action = "WikiServlet?command=wikiListS";
	document.formm.submit();
}
function click3() {
	document.formm.action = "WikiServlet?command=wikiListU";
	document.formm.submit();
}
</script>
<title>wiki 최근글</title>
</head>
<body>

<div class="col-2 ">
</div>
<div class="row">
<div class="col-7 menu2">

<div  class="col-12" style="font-size: 14px; padding-left: 10%;padding-right: 10%;"> 
<form name="formm" action="" method="post">
	<p>최근글</p>
	<div>
		<input type="button" name="humanities" onclick="click1()" value="인문학" class='button1'>
		<input type="button" name="science" onclick="click2()" value="과학" class='button1'>
		<input type="button" name="unclassified" onclick="click3()" value="미분류" class='button1'></div>	
		
			   <table style="width: 100%; height: 100px;margin-left: auto; margin-right: auto;">   
				<tr>
					<td>
					<select name="option">
						<c:forEach items="${optionList}" var="option" varStatus="status">
							<option value="${status.count}">${option}</option>
						</c:forEach>
					</select>
					<input type="text" name="key" />
					<input type=button value="검색" onclick="search()" class='button1'/></td>
				</tr>
			</table>
	<table>
		<tr>
			<th style="width: 10%;">번호</th>
			<th style="width: 10%;">분류</th>
			<th style="width: 55%;">문서명</th>
			<th style="width: 10%;">작성자</th>
			<th style="width: 15%;">작성일</th>
		</tr>
		<c:forEach var="wikiVO" items="${wikiList}">
			<tr> 
				<td style="text-align: center;">${wikiVO.wseq}</td>
				<td style="text-align: center;">${wikiVO.kind}</td>
				<td><a href="WikiServlet?command=wikiDetail&wseq=${wikiVO.wseq}">${wikiVO.title}</a></td>
				<td style="text-align: center;">${wikiVO.id}</td>
				<td style="text-align: center;"><fmt:formatDate value="${wikiVO.indate}"/></td>
			</tr>
		</c:forEach>
		<tr  style="text-align:Right;">
		<td colspan="5"><input type="button" onclick="location.href='WikiServlet?command=wikiInsert_form'" value="글쓰기" class='button1'/></td>
		</tr>
	</table>
</form>
</div>

</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>

</body>
</html>