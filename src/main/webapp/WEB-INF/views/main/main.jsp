<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	img{
		width : 200px;
		height : 200px;
	}

</style>

			<div class="blog-header">
				<h1 class="blog-title">Main</h1>
				<p class="lead blog-description">계층형 게시판[${S_MEMBER.userId }]</p>
			</div>
		
			<div class="row">
			
				<div class="col-sm-8 blog-main">
			
					<div class="blog-post">
						<h2 class="blog-post-title">계층형 게시판 만들기</h2>
						<p class="blog-post-meta">
							2020.11.14 김윤환
						</p>
						<img src="${pageContext.request.contextPath }/images/thumbsup.PNG">
						<p>계층형 게시판 만들기 (ver. Spring)</p>
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
							<li>서블릿 환경이 아닌 스프링 환경으로 구축</li>
						</ul>
					</div>
				</div>
				<!-- /.blog-main -->
			</div>	
