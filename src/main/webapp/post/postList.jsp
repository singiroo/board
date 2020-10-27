<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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

<title>게시글 목록</title>

<%@include file="/layout/commonLib.jsp" %>

<script>
	$(document).ready(function(){
		$('tbody tr').on('click', function(){
			//data-postid
			var postid = $(this).data("postid");
			console.log("tbody tr clicked!!");
			console.log("postid : "+ postid);

			document.location="/board/post?postid="+ postid;
		});
			
	});
		
</script>
</head>

<body>


<%@ include file="/layout/header.jsp" %>		

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@ include file="/layout/left.jsp" %>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">${boardnm }</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일시</th>
				</tr>	
			<tbody id="postList">
				<c:forEach var="post" items="${postMap.postList }">
					<tr data-postid="${post.postid }">
					<td>${post.postid }</td>
					<td>${post.title }</td>
					<td>${post.userid }</td>
					<!-- format : yyyy-MM-dd -->
					<td>
					 	<fmt:formatDate value="${post.dates }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					</tr>
			
				</c:forEach>			
			</tbody>
			</table>
		</div>
				
		<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/postCreate?boardid=${boardid}">새 글 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
				<li><span>&lt;&lt;</span></li>
				<li><span>&lt;</span></li>
			
			
				<c:forEach var="i" begin="1" end="${totalPage }" >
					<c:choose>
						<c:when test="${i == pageVo.page}">
							<li class="active"><span>${i}</span></li>					
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/postList?page=${i}&pagesize=${pageVo.pageSize}&boardid=${boardid}&boardnm=${boardnm}">${i }</a></li>					
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<li><span>&gt;</span></li>
				<li><span>&gt;&gt;</span></li>
				
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>