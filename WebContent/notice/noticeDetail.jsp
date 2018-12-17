<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>

<title>공지사항</title>
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
<div class="col-12">	
<!-- ---------------------------------------------- -->
			<div class="col-12">
<p>공지사항</p>
				<table>
					<thead>
						<tr>
							<th style=" width:600px; font-size: 20px;">${Detail.title}</th>
						</tr>
						<tr>
							<td
								style="background-color: #ededed; font-size: 10px; border-bottom: 1px solid #777777; text-align: center;">NO:${Detail.no}
								ID:${Detail.id} ${Detail.indate}</td>
						</tr>
						<tr>
						<td style=" border-bottom: 1px solid #777777;">
						<p style="margin: 16px; porder-top: 200px; height: 201px;">${Detail.text}</p>						
						</td>
						</tr>
						<tr>
						<td style="text-align:Right;"><a href='javascript:history.go(-1)'><input type="button" value="뒤로가기"class='button1'></a></td>
						
						</tr>
						
					</thead>
				</table>
				
			</div>



			<!-- --------------------------------------------------- -->
</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>
</body>
</html>