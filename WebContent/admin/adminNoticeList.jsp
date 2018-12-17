<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 리스트</title>
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
							
					공지리스트
					
					<div  class="col-12" style="font-size: 14px; padding-left: 10%;padding-right: 10%;"> 
	
	<table>	
       <thead>
			<tr>
			    <th style="width: 50px;">NO</th>
				<th style="width: 300px;">제목</th>
				<th style="width:100px;">작성자</th>
				<th style="width: 120px;">작성일</th>				
			</tr>
		</thead>		
		<c:forEach  items="${List}" var="noticeLest" >	
		<tr>
		<td><%-- <input type="hidden"name="no"value="${noticeLest.no}"> --%>${noticeLest.no}</td>				
		<td><a href="WikiServlet?command=wiki_adminNotice_Detail&no=${noticeLest.no}">${noticeLest.title}</a></td>					
		<td>${noticeLest.id}</td>		
		<td><fmt:formatDate value="${noticeLest.indate}"/></td>
		<td>
		<!-- 넘겨주기 힘들엉ㅇㅇㅇㅇㅇㅇㅇㅇ -->
		<form name="formm"method="post" action ="WikiServlet?command=wiki_adminNotice_delete">
		<input type="hidden"name="no"value="${noticeLest.no}">	
			<input type="submit" type=button class='button1'name="no"value="삭제">
			</form></td>
		</tr>
				
		</c:forEach>	
		</tbody>	
		<tr style="text-align:Right;">
		<td colspan="4">
				
		<input type="button"value="공지사항 쓰기" onclick="location.href='WikiServlet?command=wiki_adminNotice_Update_form'" class='button1'>
		</td></tr>	
		</table>
		</div>					
							
					<!-- --------------------------------------------------- -->
				</div>
			</div>


		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>