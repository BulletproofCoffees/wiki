<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
		<div class="col-7 menu index">
			<h1>위키대문</h1>
			<p>
			<c:forEach items="${count}" var="count">
			문서갯수${count.wseq}
			</c:forEach>
				<br /> 환영합니다!<br /> 누구나 기여할 수 있는 위키입니다.
			</p>

<script>
alert(ip());
	$(document).ready(function() {
		$("#spreadBtn").click(function() {
			if ($("#hiddenList").is(":visible")) {
				$("#hiddenList").slideUp();
			} else {
				$("#hiddenList").slideDown();
			}
		});
	});
</script>			
			
			<ul>
				<li><a id="spreadBtn">공지 사항</a></li>
				<div id="hiddenList">
					<c:forEach items="${noticeList}" var="Lest">
						<div id="List">
							<a href="WikiServlet?command=wiki_Notice_Detail&no=${Lest.no}">${Lest.title}</a>
							<a id="float"><fmt:formatDate value="${Lest.indate}" pattern="MM.dd" /></a>
						</div>
					</c:forEach>
				</div>
				<li><a href="WikiServlet?command=clause">이용약관</a></li>
			</ul>
			
				<div class="col-6 menu">
					<div class="aside">
						<h2>오늘의 글</h2>
						<p>기능 없음</p>
					</div>
				</div>

				<div class="col-6 menu">
					<div class="aside">
						<h2>오늘의 글</h2>
						<p>기능 없음</p>
					</div>
				</div>
			
		
				<div class="col-6 menu">
					<div class="aside">
						<h2>오늘의 글</h2>
						<p>기능 없음</p>
					</div>
				</div>

				<div class="col-6 menu">
					<div class="aside">
						<h2>오늘의 글</h2>
						<p>기능 없음</p>
					</div>
				</div>
			</div>
		