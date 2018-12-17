<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/baes.css" rel = "stylesheet">
<link href="css/wiki.css" rel = "stylesheet">
<link href="css/wikiDetail.css" rel = "stylesheet">
</head>
<body>


<div class="header">
	        	<c:choose>
		<c:when test="${adminid == null}">
			<a href="WikiServlet?command=wiki_admin_login_form">로그인</a>
		</c:when>		
		<c:otherwise>
    ${adminid} 관리자님  /<a href="WikiServlet?command=logout">로그아웃</a>        		
			</c:otherwise>
	        </c:choose>
			</div>					
</body>
</html>