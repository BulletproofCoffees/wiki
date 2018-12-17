<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>

<title>관리자 공자사항</title>
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
					공지사항 디테일 수정                                      
                     <form method="post" name="formm" action ="WikiServlet?command=wiki_adminNotice_Modified" >	
		<table>
			<td>글번호</td>
				<td colspan="20"><input type="hidden"name="no"value="${Detail.no}">${Detail.no}</td>
				</tr>
				<tr>
			<td>작성자</td>
				<td colspan="20">${adminid}</td>
					</tr>
					<tr>
				<td>제목</td>
				<td colspan="20"><input type="text" size="30" name="title"value="${Detail.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="20"><textarea rows="9" cols="50" name="text"> ${Detail.text}</textarea>
				</td>
			</tr>
			<tr>
			
		</table>
		<input type="submit" type=button value='공지사항수정'하기'> 
					
					</form>	
					 				
					<!-- --------------------------------------------------- -->
				</div>
			</div>


		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>