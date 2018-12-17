<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>

<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
<div class="col-12">	
<h1>로그인</h1>
<form method="post" action="WikiServlet?command=login">
<div class=camt>
<p><label>User ID</label></p>
<input type="text" name="id" value="${id}"><br>
<c:choose>
<c:when test="${adminid != null}"></c:when>
<c:otherwise ><p style="color: #ff3030; font-size: 12px;">${message}</p></c:otherwise>
</c:choose>			
<p><label>Password</label></p>
<p><input type="password" name="pwd" value="${pwd}"><br></p>
<input type="button"value="계정만들기" onclick="location.href='WikiServlet?command=join_form'" class='button1'>
<input type="submit" value="로그인" class='button1'>
</div>
</form>

</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>
