<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="include/header.jsp" %>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
			
<div class="box-body">
	<div class="form-group">
		<label>제목</label>
		<input type="text" name="title"
		class="form-control" value="${vo.title}"
		readonly="readonly" />
	</div>
	
	<div class="form-group">
		<label>내용</label>
		<textarea name="content" rows="5"
		readonly="readonly" class="form-control">${vo.content}</textarea>
	</div>
				
	<div class="form-group">
		<label>작성자</label>
		<input type="text" 
		class="form-control" value="${vo.nickname}"
		readonly="readonly" />
		</div>
	</div>
			<div class="box-footer">
	<button class="btn btn-success" id="mainbtn">메인</button>
	<button class="btn btn-primary" id="listbtn">목록</button>
</div>
</div>
</section>
<%@ include file="include/footer.jsp" %>	
<script>
	//메인 버튼을 눌렀을 때 처리
	document.getElementById("mainbtn").addEventListener("click", function(){
		location.href="./";
	});
	//목록 버튼을 눌렀을 때 처리
	document.getElementById("listbtn").addEventListener("click", function(){
		location.href="./list.do";
	});
</script>

	