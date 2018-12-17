<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function mypage(){
	document.formm.action = "WikiServlet?command=mypage";
	document.formm.submit();
}
function update(){
	document.formm.action = "WikiServlet?command=mypageupdate";
	document.formm.submit();
}
</script>
<!-- <title>기본틀</title> -->
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
<div  class="col-12" style="padding-left: 10%;padding-right: 10%;"> 
<!-- ---------------------------------------------- -->
<form name="formm" method="post" action="">
<c:choose>
<c:when test="${memberVO.id != null}">
<div><h4 style="font-weight:bold;"> 아 이 디 : <input type="text" value="${memberVO.id}" name="idupdate"></h4></div>
</c:when>
<c:otherwise>
<div><h4 style="font-weight:bold;"> 아 이 디 : <label style="font-weight:normal;">${loginUser.id}</label></h4></div>
</c:otherwise>
</c:choose>
<input type="hidden" name="id" value="${loginUser.id}">

<c:choose>
<c:when test="${memberVO.id != null}">
<div><h4 style="font-weight:bold;"> 이 메 일 : <input type="text" value="${memberVO.email}" name="emailupdate"></h4></div>
</c:when>
<c:otherwise>
<div><h4 style="font-weight:bold"> 이 메 일 : <label style="font-weight:normal;">${loginUser.email}</label></h4></div><br />
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${memberVO.id != null}">
<div><h4 style="font-weight:bold;">비밀번호 : <input type="password" value="${memberVO.pwd}" name="pwdupdate"></h4></div><br />
</c:when>
</c:choose>
<input type="hidden" name="email" value="${loginUser.email}">
<c:choose>
<c:when test="${memberVO.id != null}">
<input type="button" class="button1" value="수정하기" onclick="update()">
</c:when>
<c:otherwise>
<input type="button" class="button1" value="회원정보 수정" onclick="mypage()">
</c:otherwise>
</c:choose>

</form>
<!-- --------------------------------------------------- -->
</div>
</div>
<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>