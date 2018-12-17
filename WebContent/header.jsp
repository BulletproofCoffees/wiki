<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/baes.css" rel = "stylesheet">
<link href="css/wiki.css" rel = "stylesheet">
<link href="css/wikiDetail.css" rel = "stylesheet">
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://unpkg.com/ionicons@4.2.4/dist/ionicons.js"></script> 
<script type="text/javascript" src="http://jsgetip.appspot.com"></script>
</head>
<body>

<div class="header">
	<a href="WikiServlet?command=index">
		 <img src="images/로고.png"width="100" height="34" alt="위키">
		</a>
		
		<div class = "text">
		<ul>
			<li><a href="WikiServlet?command=wikiList"> 최근글</a></li> 
			<li><a href="WikiServlet?command=wiki_forum"> 포럼</a></li>
			<li><a href="WikiServlet?command=wiki_notice_lest"> 공지</a></li>
		</ul>
	        </div>
	        	        		
			<div class ="Search" >
					
			  <c:forEach  items="${random}" var="random">
			  <div class="ion"><a href="WikiServlet?command=wikiDetail&wseq=${random.wseq}"><ion-icon name="shuffle"></ion-icon></a></div></c:forEach>	
			 		
			 <form method="post" action="WikiServlet?command=document_search">										
	        <div><input type="search" id="searchbox" placeholder="검색어" name="search"></div>
			<div class="ion"><button><ion-icon name="search">검색</ion-icon></button></div>	
			</form>	
			
			
					
			<c:choose>
			<c:when test="${empty sessionScope.loginUser}">
			<div class="ion"><a href="WikiServlet?command=login_form"><ion-icon name="log-in">로그인</ion-icon></a></div>		
			</c:when>
			
			<c:otherwise>					
			<div class="ion"><a href="WikiServlet?command=my"><ion-icon name="contact">마이페이지</ion-icon></a></div>
			<div class="ion"><a href="WikiServlet?command=logout"><ion-icon name="log-out">로그아웃</ion-icon></a></div>									
			</c:otherwise>
			</c:choose>	
			</div>		
			</div>			
				
</body>
</html>