<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript"> 

function han(obj) { 
var pattern = /[^(ㄱ-힣)]/; //한글만 허용 할때 
if (pattern.test(obj.value)) { 
alert("한글만 허용합니다."); 
obj.value = ''; 
obj.focus(); 
return false; 
} 
} 
function eng(obj) { 
var pattern = /[^(a-zA-Z0-9)]/; //영문만 허용 
if (pattern.test(obj.value)) { 
alert("영문만 허용합니다."); 
obj.value = ''; 
obj.focus(); 
return false; 
} 
} 
function all(obj) { 
var pattern = /[^(ㄱ-힣a-zA-Z0-9)]/; //한글,영문,숫자만 허용 
if (pattern.test(document.getElementById('name').value)) { 
alert("한글,영문,숫자만 허용합니다."); 
obj.value = ''; 
obj.focus(); 
return false; 
} 
} 
</script> 

한글이름 : <input type="text" name="kName" style="ime-mode:active;" onkeyup="han(this)"> <br/> 
영어이름 : <input type="text" name="eName" style="ime-mode:inactive;" onkeyup="eng(this)"> <br/>
</body>
</html>