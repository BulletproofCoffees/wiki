<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>아이디 중복체크</title>
<link href="css/shopping.css" rel="stylesheet">
<script>
function idchk(){
	opener.formm.id.value="${id}";
	self.close();
}

</script>
<link href="CSS/subpage.css" rel="stylesheet">
<body>
<div id="wrap">

<h2>중복확인</h2>
<form method = "post" name="formm" style="magin-right:0">
<c:if test="${message==1 }">
<script type="text/javascript">
opener.document.formm.id.value="";
</script>
${id}는 이미 사용중입니다.
</c:if>
<c:if test="${message==-1}">
${id}는 사용가능한 아이디입니다.
<input type="button" value="사용" onclick="idchk()">
</c:if>
</form>

</div>
</body>
</html>



