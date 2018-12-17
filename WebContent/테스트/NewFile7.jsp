<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

</head>
<body>
	<button id="hide" class="btn btn-primary">에디터</button>
	<button id="show" onclick="showContent();" class="btn btn-primary">미리보기</button>
	<form action="WikiServlet?command=wikiUpdate2" method="post" name="formm">
		<div id="a">
			<textarea id="summernote" name="title"></textarea>
		</div>
		<div class="output"></div>
		<input type="submit" type=button value='저장'>
	</form>





	<script>
		$('#summernote').summernote({});
		function showContent() {
			$('.output').html($('#summernote').summernote('code'));
		}

		window.onload = $(document).ready(function() {
			$(".output").hide();

			$("#hide").click(function() {
				$(".output").hide();
				$("#a").show();
			});
			$("#show").click(function() {
				$(".output").show();
				$("#a").hide();
			});
		});
	</script>


</body>
</html>