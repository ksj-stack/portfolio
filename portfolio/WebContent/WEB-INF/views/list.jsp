<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<div class="box">
	<div class="box-header with-border">
		<c:if test="${msg == null}">
			<h3 class="box-title">게시판 목록보기</h3>
		</c:if>

		<c:if test="${msg != null}">
			<h3 class="box-title">${msg}</h3>
		</c:if>
	</div>
	<div class="box-body">
		<table class="table table-bordered table-hover">
			<tr>
				<th width="11%">글번호</th>
				<th width="46%">제목</th>
				<th width="16%">작성자</th>
				<th width="16%">작성일</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="right">${vo.bno}&nbsp;</td>
					<td>&nbsp; <a href="detail.do?bno=${vo.bno}">${vo.title}</a></td>
					<td>&nbsp;${vo.nickname}</td>

					<td>&nbsp; ${vo.regdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="box-footer">
		<div class="text-center">
			<button id='mainBtn' class="btn-primary">메인으로</button>
		</div>

		<script>
	document.getElementById('mainBtn').addEventListener("click", function(event) {
		location.href = "./";
	});
</script>
	</div>
</div>
<%@include file="include/footer.jsp"%>
