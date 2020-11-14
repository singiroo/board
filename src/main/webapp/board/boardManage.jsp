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

<title>게시판 관리 페이지</title>

<%@include file="/layout/commonLib.jsp" %>

<script>


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
		<h2 class="sub-header">게시판</h2>
		<div class="table-responsive">
		
			<fieldset>
				<legend> * 게시판 생성</legend>
				<form action="${pageContext.request.contextPath }/boardCreate" method="post">
					<label for="boardnm">게시판 이름 : </label>
					<input type="hidden" name="userid" value="${S_MEMBER.userId }"/>
					<input type="text" id="boardnm" name="boardnm" value="" placeholder="게시판 이름">
					<input type="submit" value="생성"/>
				</form>
			</fieldset>
			<br><br>
			<fieldset>
				<legend> * 게시판 목록</legend>
				<c:forEach var="board" items="${boardList }">
					<form action="${pageContext.request.contextPath }/updateBoard" method="get">
						<label>게시판 이름 : </label>
						<input type="hidden" name="boardid" value="${board.boardid }">
						<input type="text" name="boardnm" value="${board.boardnm }" readonly>
							<select name="boardstatus">
								<c:choose>
									<c:when test="${board.boardstatus =='T' }">
										<option value="T" selected>사용</option>
										<option value="F">미사용</option>
									</c:when>
									<c:otherwise> 
										<option value="T">사용</option>
										<option value="F" selected>미사용</option>
									</c:otherwise>
								</c:choose>
							</select>
						<input type="submit" value="수정"/>
					</form>
					<br>
				</c:forEach>
			</fieldset>
		</div>
		
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
