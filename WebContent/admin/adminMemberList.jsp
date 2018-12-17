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
			<%@ include file="/admin/adminNoLogin.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="/admin/adminBar.jsp"%>
			<div class="row">
				<div class="col-9 member">
					<!-- ---------------------------------------------- -->
							
					<div style="font-size: 14px; padding-left: 30px; padding-right: 30px;">
					<!-- <ul class="member">
                   <li style="background-color:#ffffff;">회원리스트</li>
                   <li><a href="WikiServlet?command=admin_member_vandalist">반달회원리스트</a></li>
                   <li><a href="#">탈퇴회원 리스트(테이블 만글어야함안만듬 ㅡㅡ)</a></li>
                    </ul>		 -->
							<table>
								<thead>
									<tr >
										<th style="width: 100px;">아이디</th>
										<th style="width: 50px;">비번</th>
										<th style="width: 200px;">이메일</th>
										<!-- <th style="width: 50px;">반달</th>										
										<th style="width: 50px;">탈퇴</th> -->
										<th style="width: 100px;">가입일</th>
									</tr>
								</thead>
								<c:forEach items="${VO}" var="Lest">
									<tr>										
										<td>${Lest.id}</td>
										<td>${Lest.pwd}</td>
										<td>${Lest.email}</td>
										<%-- <td>${Lest.vandals}</td>
										<td>${Lest.usetn}</td> --%>
										<td><fmt:formatDate value="${Lest.indate}"/></td>
										<td><form name="formm" action="WikiServlet?command=admin_member_delete" method="post">	
										<input type="hidden"name="id"value="${Lest.id}">		
										<input type="submit"value="회원삭제"class='button1'>
										</form>	
										</td>
									</tr>
								</c:forEach>
							</table>
							</div>
					
								
					<!-- --------------------------------------------------- -->
				</div>
			</div>


		</c:otherwise>
	</c:choose>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>