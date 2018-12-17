<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>wiki 포럼 </title>
</head>
<body>

<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 background">
<div class="col-12">	
<p>포럼</p>
	<table>	
       <thead>
			<tr>
				<th style="width: 300px;">제목</th>
				<th style="width:100px;">작성자</th>
				<th style="width: 100px;">작성일</th>				
			</tr>
		</thead>
		<tbody >
		<c:forEach  items="${forum}" var="Lest" >			
		<tr id="lest">			
		<td><a href="WikiServlet?command=wiki_forum_Detail&no=${Lest.no}">${Lest.title}</a>	</td>							
		<td style="text-align: center;">${Lest.id}</td>		
		<td style="text-align: center;"><fmt:formatDate value="${Lest.indate}"/></td>		
		</tr>		
		</c:forEach>
		</tbody>	
		<tr style="text-align:Right;">
		<td colspan="3"><input type="button"value="새포럼" onclick="location.href='WikiServlet?command=wiki_forum_Insert_form'" class='button1'></td></tr>	
		</table>		
</div>
</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>

</body>
</html>