<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	function onfocus_event() {
		if (document.formm.loginuser.value === "") {
			document.formm.action = "WikiServlet?command=login_form";
			document.formm.submit();
			/* if(login == true){
				document.formm.action = "WikiServlet?command=login_form";
				document.formm.submit();
			}else if(login == false){
				document.formm.action = "WikiServlet?command=wiki_forum";
				document.formm.submit();
			} */
		}
	}
	function asd() {

		document.formm.action = "WikiServlet?command=wiki_forum_Detail";
		document.formm.submit();
	}
	function a() {
		document.formmm.action = "WikiServlet?command=cDelete";
		document.formmm.submit();
	}
	// 댓글 데이터베이스 엔터적용
	function aa() {
		document.getElementById("commentText").onkeyup = processText;
		function processText() {
			var txtBox = document.getElementById("commentText");
			var lines = txtBox.value.split("\n");
			var sString = "";
			for (var i = 0; i < lines.length; i++) {
				sString += lines[i] + "<br />";
			}
			var blk = document.getElementById("result2");
			blk.value = sString;
		}
	}
	function b() {
		document.getElementById("conversion").onkeyup = processText;
		function processText() {
			var txtBox = document.getElementById("conversion");
			var lines = txtBox.value.split("<br />");
			var String = "";
			for (var i = 0; i < lines.length; i++) {
				String += lines[i] + "\n";
			}
			var blk = document.getElementById("content1");
			blk.value = String;
		}
	}
	//
</script>
<title>포럼</title>
</head>
<body>
	<%@ include file="/ground/col.jsp"%>
	<div class="row">
		<div class="col-7 menu">
		<div class="col-12">
		
			<!-- ---------------------------------------------- -->
			
				<div class="col-8">	
				<table style="width: 100%; height: 100px;margin-left: auto; margin-right: auto;border: 1px solid #d8d8d8;">
					<thead>
						<tr><td style="font-size: 15px;border-bottom: 1px solid #777777; height: 30px;">${Detail.title}</td></tr>
						<tr>
							<td style="font-size: 10px; border-bottom: 1px solid #777777; height: 20px;">ID:${Detail.id} ${Detail.indate}</td>
						</tr>
						<tr>
						<td >
						<p style="margin: 16px; porder-top: 200px;">${Detail.text}</p>						
						</td>
					</thead>
				</table>
			</div>
			<div class="col-12 " style="padding: 0px;" ></div>			
			<div class="col-4 " ></div>			
			<div class="col-8" >									
				<c:if test="${commentList != null}">
							<c:forEach items="${commentList}" var="commentList1">
								
										<form name="formmm" method="post" action="WikiServlet?command=wiki_forum_Detail&no=${Detail.no}">
										<div style=" border: 1px solid #d8d8d8; margin: 15px;">							
											<c:choose>
												<c:when test="${commentList1.fid == commentList1.id}">													
													<b style="color: blue;">작성자</b>													
																							
												</c:when>
												<c:otherwise>
														<b>${commentList1.id}</b>
														
												</c:otherwise>
											</c:choose>
											
											<c:choose>
												<c:when test="${loginUser.id == commentList1.id}">		
																						
													<p style="margin: 16px; porder-top: 200px;">${commentList1.commen}</p>
													<input type="hidden" value="${commentList1.no}" name="no1">
													<input type="hidden" value="${commentList1.nno}" name="no">
													<div style="text-align:right"><input type="submit" value="댓글 삭제" class='button2' >	</div>
												</c:when>
												<c:otherwise>																	
													<p style="margin: 16px; porder-top: 200px;">${commentList1.commen}</p>													
													<input type="hidden" value="${commentList1.no}" name="no1">
													<input type="hidden" value="${commentList1.nno}" name="no">
												</c:otherwise>
											</c:choose>
											</div>
										</form>								
							</c:forEach>
						</c:if>								
			</div>				
				<div>
				<form name="formm"action="WikiServlet?command=wiki_forum_Detail&no=${Detail.no}"method="post">
				<textarea class="col-12 textbox" name="commen"placeholder="댓글 이용은 로그인 후 가능합니다." onfocus="onfocus_event();"id="commentText" 
				onkeyup="aa()" style=" margin-bottom: 20px;"></textarea>	
				<div><input type="button" value="댓글 달기" style="float: right" onclick="asd()" class='button1'></div>
				<input type="hidden" value="${loginUser.id}"name="loginuser">
				<input type="hidden" value="${Detail.no}" name="no">
				<input type="hidden" value="${loginUser.id}" name="1"id="commentID">
				<input type="hidden" name="result" id="result2">	
					</form>				
			</div>
			
			
			<!-- --------------------------------------------------- -->
			
			</div>
		</div>
		<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>