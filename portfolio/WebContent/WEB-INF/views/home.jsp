<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<section class="content">

	<h1 align="center">안녕하세요!</h1>
	<p align='center'><img src="images/lion.gif" width="50%" height="50%"></p>
	<h3 align='center'>저는 재현중학교 3학년 김성준이라고 합니다.</h3>

</section>

<c:if test="${insert != null }">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	$(function() {
	    $("#dialog-confirm" ).dialog({
	      resizable: false,
	      height: "auto",
	      wemailth: 400,
	      modal: true,
	      buttons: {
	        "닫기": function() {
	          $( this ).dialog( "close" );
	        },
	      }
	    });
	  } );
	</script>
</c:if>
<div id="dialog-confirm" title="회원가입" style="display:none">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>회원가입에 성공하셨습니다.이제 로그인하고 사용하시면 됩니다.</p>
</div>

<%@include file="include/footer.jsp"%>
   