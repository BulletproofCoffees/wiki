<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<script>
function login_chk() {
	if (document.formm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.login.id.focus();
		return;
	}
	var url="WikiServlet?command=id_chack_form&id=" + document.formm.id.value;
	window.open(url,"_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no,width=330,height=200");
}
function joinsuccess() {
	document.formm.action = "WikiServlet?command=join";
	document.formm.submit();
}

function chkword(obj, maxByte) {
	 
    var strValue = obj.value;
    var strLen = strValue.length;
    var totalByte = 0;
    var len = 0;
    var oneChar = "";
    var str2 = "";

    for (var i = 0; i < strLen; i++) {
        oneChar = strValue.charAt(i);
        if (escape(oneChar).length > 4) {
            totalByte += 2;
        } else {
            totalByte++;
        }

        // 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
        if (totalByte <= maxByte) {
            len = i + 1;
        }
    }
    if (totalByte > maxByte) {
        alert(maxByte + "자를 초과 입력 할 수 없습니다.");
        str2 = strValue.substr(0, len);
        obj.value = str2;
        chkword(obj, 4000);
    }
    
    var pattern = /[^(a-zA-Z0-9)]/; //영문만 허용 
	if (pattern.test(obj.value)) { 
	alert("영문만 허용합니다."); 
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
	
function en(obj) { 
	var pattern = /[^(a-zA-Z0-9)]/; //영문숮자만 허용 
	if (pattern.test(obj.value)) { 
	alert("영문,숫자만 허용합니다."); 
	obj.value = ''; 
	obj.focus(); 
	return false; 
	} 
	} 


</script>

<title>위키 계정만들기</title>
</head>
<body>
<%@ include file="/ground/col.jsp"%>
<div class="row">
<div class="col-7 menu">
<div class="col-12">	
<h1>계정 만들기</h1>

<form action ="WikiServlet?command=join" method="post" name="formm">
<p>아이디</p><input type="text" name="id" size="20px"onkeyup="chkword(this,7)">
<input type="button" class="button1" value="중복체크" onclick="login_chk()"/><br>


<p>비밀번호 </p><input type="password" name="pwd" size="30px" >

<p>비밀번호확인</p><input type="password" name="pwdCheck" size="30px">

<p >이메일</p><input type="text" name="email" size="30px" onkeyup="en(this)">
<div class="clear"></div>
<p style="padding-left: 55px;">
			<input type="button" value='회원가입' class="button1" onclick="joinsuccess()"> 
			<input type="reset" value='취소' class="button1"> 
</p>
</form>


</div>
</div>
	<%@ include file="/ground/bar.jsp"%>
	</div>
	<%@ include file="/ground/footer.jsp"%>

</body>
</html>