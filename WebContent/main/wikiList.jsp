<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
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
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
			<div class="col-12 lest">
<!-- ----------------------------------------------------------------------------------------------------  -->			
				<form name="formm"method="post">
					<p>최근글
					<c:forEach items="${count}" var="count">
			문서갯수${count.wseq}
			</c:forEach></p>
					<!-- <div>
						<input type="button" name="humanities" onclick="click1()"value="인문학" class='button1'>
						<input type="button"name="science" onclick="click2()" value="과학" class='button1'>
						<input type="button" name="unclassified" onclick="click3()"value="미분류" class='button1'>
					</div> -->
					<table>
						<%-- <tr>
							<td colspan="5">
							<select name="option">
									<c:forEach items="${optionList}" var="option" varStatus="status">
										<option value="${status.count}">${option}</option>
									</c:forEach>
							</select> <input type="text" name="key" />
							 <input type=button value="검색" onclick="search()" class='button1' /></td>
						</tr> --%>
						<tr>
							<th style="width: 10%;">문서번호</th>
							<!-- <th style="width: 10%;">분류</th> -->
							<th style="width: 55%;">문서명</th>
							<th style="width: 10%;">작성자</th>
							<th style="width: 15%;">작성일</th>
						</tr>
						<c:forEach var="wikiVO" items="${wikiList}">
							<tr>
								<td id="td">${wikiVO.wseq}</td>
								<%-- <td id="td">${wikiVO.kind}</td> --%>
								<td><a href="WikiServlet?command=wikiDetail&wseq=${wikiVO.wseq}">${wikiVO.title}</a></td>
								<td id="td">${wikiVO.id}</td>
								<td id="td"><fmt:formatDate value="${wikiVO.indate}" pattern="MM/dd"/></td>
							</tr>
						</c:forEach>
					</table>
				</form>
<!-- ----------------------------------------------------------------------------------------------------  -->	
			</div>
		</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>

</body>
</html>