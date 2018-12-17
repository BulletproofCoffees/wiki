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
			<%@ include file="/admin/adminNoLogin.jsp" %>
		</c:when>
		<c:otherwise>		
			<%@ include file="/admin/adminBar.jsp"%>
			<div class="row">
				<div class="col-9 menu">
					<!-- ---------------------------------------------- -->
					<form name="formm" action="" method="post">

						관리자 모드
						
						</form>
					<!-- --------------------------------------------------- -->
				</div>
			</div>
			
			
		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>