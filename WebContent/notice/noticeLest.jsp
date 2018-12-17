<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<title>wiki 공지사항</title>
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 background">
<div class="col-12">	

<p>공지사항</p>
   
   <table>   
       <thead>
         <tr>
            <th style="width: 250px;">제목</th>
            <th style="width:70px;">작성자</th>
            <th style="width: 100px;">작성일</th>            
         </tr>
      </thead>      
      <c:forEach  items="${noticeLest}" var="noticeLest" >         
      <tr id="lest">         
      <td><a href="WikiServlet?command=wiki_Notice_Detail&no=${noticeLest.no}">${noticeLest.title}</a></td>               
      <td style="text-align: center;">${noticeLest.id}</td>      
      <td style="text-align: center;"><fmt:formatDate value="${noticeLest.indate}"/></td>      
      </tr>      
      </c:forEach>               
      </table>   
</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>