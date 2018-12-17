<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col- ">
<div class="aside">
<h2>최근글</h2>
<ul>
<c:forEach  items="${List}" var="Lest" >
<li style="color: black;">
<a href="WikiServlet?command=wikiDetail&wseq=${Lest.wseq}" style="margin-right: 30px;">${Lest.title}</a>
<a id="bara"><fmt:formatDate value="${Lest.indate}"  pattern="HH:mm"/></a></li>	
</c:forEach>
</ul>
</div>

<p></p>
<div class="aside">
<h2>포럼</h2>
<c:forEach  items="${forumList}" var="forum" >	
<li><a href="WikiServlet?command=wiki_forum_Detail&no=${forum.no}" style="margin-right: 30px;">${forum.title}</a>
<a id="bara"><fmt:formatDate value="${forum.indate}"  pattern="HH:mm"/></a></li>
</c:forEach>
</div>
</div>
