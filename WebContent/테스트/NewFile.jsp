<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div style="float: left;">
	<div>분류
	<select><option value="${status.count}">${kind}</option></select>
	</div>
	
	 <div>제목
	<input type="text" size="30" name="title" id='title' onkeyup="h1()"value="${wikiVO.title}">
	</div>
	

	<div><input type="button"></div>
	
	<div><textarea rows="9" cols="50" name="content" id="content1"
		class="textbox" onKeyUp="calculationtest()">${wikiVO.content}</textarea>
		</div>	
	이미지
	<img src="wiki_images/${wikiVO.image}">
	<input type="file" size="20" name="image"/>	
	<div><input type="button" onclick="wikiInsert()" value="등록"></div>
	</div>
	출력
	<div id="result"></div>
	<div id="result2"></div>
</body>
</html>