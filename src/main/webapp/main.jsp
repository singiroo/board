<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>계층형 게시판</title>

<%@include file="/layout/commonLib.jsp" %>

</head>

<body>

<%@ include file="/layout/header.jsp" %>	

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@ include file="/layout/left.jsp" %>
</div>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="blog-header">
	<h1 class="blog-title">Main</h1>
	<p class="lead blog-description">계층형 게시판[${S_MEMBER.userId }]</p>
</div>

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<h2 class="blog-post-title">계층형 게시판 만들기</h2>
			<p class="blog-post-meta">
				2020.10.26, 김윤환
			</p>

			<p>계층형 게시판 만들기</p>
			<hr>
			
			<h3>상세내역</h3>
			<p>게시판 작성 요구사항</p>
			<ul>
				<li>모든 기능은 로그인을 한 후에 이용가능</li>
				<li>게시판생성 기능</li>
				<li>게시판 활성/비활성화 설정 기능</li>
				<li>게시글 등록/수정/삭제/답글등록 기능</li>
				<li>댓글 등록 기능</li>
				<li>게시글 등록시 이미지 포함가능</li>
				<li>게시글 등록시 첨부파일 포함가능 최대 5개</li>
			</ul>
		</div>
	</div>
	<!-- /.blog-main -->
</div>	</div>
		</div>
	</div>
</body>
</html>
