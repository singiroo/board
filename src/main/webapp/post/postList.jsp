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

<title>Jsp</title>

<%@include file="/layout/commonLib.jsp" %>

<script>
	$(document).ready(function(){
		$('tbody tr').on('click', function(){
			//data-userId
			var userid = $(this).data("userid");
			console.log(userid);
			console.log("tbody tr click!!");
			console.log("userId : "+ userid);

			document.location="/jsp/member?userId="+ userid;
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
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>	
			<tbody id="postList">
				<c:forEach var="post" items="${map.postList }">
					<tr data-postid="${post.postid }">
					<td>${post.postid }</td>
					<td>${post.title }</td>
					<td>${post.userid }</td>
					<td>${post.dates }</td>
					<!-- format : yyyy-MM-dd -->
					<td>
					 	<fmt:formatDate value="${post.dates }" pattern="yyyy-MM-dd"/>
					</td>
					</tr>
			
				</c:forEach>			
			</tbody>
			</table>
		</div>
				
		<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/postCreate">새 글 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<c:forEach var="i" begin="1" end="${map.totalPage }" >
					<c:choose>
						<c:when test="${i == pageNo}">
							<li class="active"><span>${i}</span></li>					
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/postList?page=${i}&pageSize=${pageSize}">${i }</a></li>					
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>