<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>관리자페이지 로그인</title>
</head>
<body>
<div class="col-2 ">
</div>
<div class="row">
<div class="col-7 menu">
<!-- ---------------------------------------------- -->
<form method="post" action="WikiServlet?command=wiki_admin_login">
<div class=camt>
<p><label>User ID</label></p>
<input type="text" name="workid" value="${id}"><br>
<c:otherwise ><p style="color: #ff3030; font-size: 12px;">${message}</p></c:otherwise>			
<p><label>Password</label></p>
<p><input type="password" name="workpwd" value="${pwd}"><br></p>
<input type="submit" value="로그인">
</div>
</form>
<!-- --------------------------------------------------- -->
</div>
</div>
<%@ include file="/ground/footer.jsp"%>
</body>
</html>