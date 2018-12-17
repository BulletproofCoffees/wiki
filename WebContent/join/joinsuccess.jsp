<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
function login(){
		document.formm.action = "WikiServlet?command=login_form";
		document.formm.submit();
}
</script>
<article>
<p>가입성공!</p>
<form method="post" name="formm">
			<input class=submit type=button value='로그인화면으로..' onclick="login()">
</form>
</article>