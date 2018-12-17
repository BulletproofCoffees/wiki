	function go_cart() {
		if (document.formm.quantity.value == "") {
			alert("수량을 입력하여 주세요.");
			document.formm.quantity.focus();
		} else {
			document.formm.action = "WikiServlet?command=cart_insert";
			document.formm.submit();
		}
	}
	function go_order() {
		document.formm.action = "WikiServlet?command=mypage";
		document.formm.submit();
	}
	function go_cart_delete() {
		var count = 0;
		for (var i = 0; i < document.formm.cseq.length; i++) {
			if (document.formm.cseq[i].checked == true) {
				count++;
			}
		}
		if (count == 0) {
			alert("삭제할 항목을 선택해주세요.");
		} else {
			document.formm.action = "WikiServlet?command=cart_delete";
			document.formm.submit();
		}
	}
	function go_order_insert() {
		document.formm.action = "WikiServlet?command=order_insert";
		document.formm.submit();
	}
	function go_order_delete() {
		var count = 0;
		for (var i = 0; i < document.formm.oseq.length; i++) {
			if (document.formm.oseq[i].checked == true) {
				count++;
			}
		}
		if (count == 0) {
			alert("삭제할 항목을 선택해주세요.");
		} else {
			document.formm.action = "WikiServlet?command=order_delete";
			document.formm.submit();
		}
	}
	
	function go_next(){
		if(document.formm.chk[0].checked == true){
			document.formm.chk.action = "WikiServlet?command=join_form";
			document.formm.submit();
		}else if(document.formm.chk[1].checked  == true){
			alert('약관을 읽고 동의해주세요.');
		}
		

		
	}
	
	function result(zipNum,sido,gugun,dong){
		opener.document.formm.zipNum.value=zipNum;
		opener.document.formm.addr1.value=sido+""+gugun+""+dong;
		self.close();
		
	}
	function idchk(){
		opener.formm.id.value="${id}";
		self.close();
	}
	function login_chk() {
		if (document.login.id.value == "") {
			alert("아이디를 입력해주세요.");
			document.login.id.focus();
			return;
		}
		var url="WikiServlet?command=id_chack_form&id=" + document.login.id.value;
		window.open(url,"_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no,width=330,height=200");
	}
	function login_chk2() {
		document.formm.action = "WikiServlet?command=id_chack_form&id=" + document.formm.id.value;
		document.formm.submit();
	}
	function admin_login() {
		var url="WikiServlet?command=admin_login_form";
		window.open(url,"_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no,width=330,height=200");
	}
	function post_zip() {
		var url="WikiServlet?command=find_zip_num";
		window.open(url,"_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no,width=330,height=200,top=300,left=300");
	}
	
	function login_fail(){
		alert("로그인실패");
		history.go(-1);
	}
	