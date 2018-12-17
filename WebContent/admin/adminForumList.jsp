<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script>
/* 여기에 스크립트 작성해주세요 */
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
					<form name="formm" action="WikiServlet?command=wiki_adminforum_Delete" method="post">


						포럼

						<div style="font-size: 14px; padding-left: 30px; padding-right: 30px;"">
							<table>
								<thead>
									<tr>
										<th style="width: 300px;">제목</th>
										<th style="width: 100px;">작성자</th>
										<th style="width: 200px;">작성시간</th>
										<!-- <th style="width: 100px;">삭제</th> -->
									</tr>
								</thead>
								<c:forEach items="${forum}" var="Lest">
									<tr>
										<td><%-- <a
											href="WikiServlet?command=wiki_adminforum_Detail&no=${Lest.no}"> --%>${Lest.title}<!-- </a> -->
										</td>
										<td>${Lest.id}</td>
										<td><fmt:formatDate value="${Lest.indate}"/></td>
										<%-- <td><input type="submit" value="문서삭제" class='button1' name="${Lest.no}"></td> --%>
										<td><input type="hidden" name="no" value="${Lest.no}"></td>
									</tr>
								</c:forEach>
							</table>
							</div>
					</form>
					<!-- --------------------------------------------------- -->
				</div>
			</div>


		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>