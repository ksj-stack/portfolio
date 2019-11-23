<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>김성준의 포트폴리오</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.comrespond/1.4.2respond.min.js"></script>
    <![endif]-->

</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
footer {
	position: absolute;
	bottom: 0px;
}
</style>

<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<div class="page-header">
				<h1>김성준의 포트폴리오</h1>
			</div>
		</header>
	</div>
	<c:if test="${user != null}">
		&nbsp;&nbsp;<span class="badge"><img
					src="${pageContext.request.contextPath}/userimage/${user.image}"
					width="30" height="30" /></span>${user.nickname}님
	</c:if>

	<aside class="main-sidebar">
		<section class="sidebar">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="./">메인</a></li>
				<li role="presentation"><a href="information.do">김성준에 대하여</a></li>
				<li role="presentation"><a href="school.do">학교 생활</a></li>
				<c:if test="${user==null or user.email != 'root@gmail.com'}">
				<li role="presentation"><a href="board.do">성준이에게 하고 싶은 이야기</a></li>
				</c:if>
				<c:if test="${user != null && user.email == 'root@gmail.com'}">
				<li role="presentation"><a href="list.do">이야기 읽기</a></li>
				</c:if>
				<li role="presentation"><a href="register.do">회원가입</a></li>
				<c:if test="${user==null}">
					<li role="presentation"><a href="login.do">로그인</a></li>
				</c:if>
				<c:if test="${user!=null }">
					<li role="presentation"><a href="chat.do">성준이와 채팅</a></li>
					<li role="presentation"><a href="logout.do">로그아웃</a></li>
				</c:if>
			</ul>
		</section>
	</aside>
	<div>