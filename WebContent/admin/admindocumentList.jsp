<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function search() {
		document.formm.action = "WikiServlet?command=admin_document_list";
		document.formm.submit();
	}
</script>

<!-- <title>기본틀</title> -->
</head>
<body>
	<c:choose>
		<c:when test="${adminid == null}">
			<%@ include file="/admin/adminNoLogin.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="/admin/adminBar.jsp"%>
			<div class="row">
				<div class="col-9 menu">
					<!-- ---------------------------------------------- -->
					<form name="formm" action="" method="post">
						<h2>Wiki List</h2>
						<table>
							<tr>
								<td><select name="option">
										<c:forEach items="${optionList}" var="option"
											varStatus="status">
											<option value="${status.count}">${option}</option>
										</c:forEach>
								</select> <input type="text" name="key" /><input type=button value="검색"
									onclick="search()" /></td>
							</tr>
						</table>
						<table id="wikiList">
							<tr>
								<td>번호</td>
								<td>분류</td>
								<td>제목</td>
								<td>작성자</td>
								<td>작성일</td>
							</tr>
						</table>
					</form>


					<table>
						<c:forEach var="wikiVO" items="${wikiList}">
							<tr>

								<td>${wikiVO.wseq}</td>
								<td>${wikiVO.kind}</td>
								<td><a
									href="WikiServlet?command=wikiDetail&wseq=${wikiVO.wseq}">${wikiVO.title}</a></td>
								<td>${wikiVO.id}</td>
								<td><fmt:formatDate value="${wikiVO.indate}"/></td>
								<td><form name="formmm" action="WikiServlet?command=admin_document_delete" method="post">
									<input type="hidden" name="wseq" value="${wikiVO.wseq}">
										<input type="submit" value="문서삭제" class='button1'name="${wikiVO.wseq}">
									</form></td>
							</tr>
						</c:forEach>
						<tr>
							<td><input type="button"
								onclick="location.href='WikiServlet?command=wikiInsert_form'"
								value="글쓰기" /></td>
						</tr>
					</table>

					<!-- --------------------------------------------------- -->
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>