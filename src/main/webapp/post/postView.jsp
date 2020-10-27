<%@page import="kr.or.ddit.member.model.MemberVO"%>
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

<title>계층형 게시판</title>

<%@include file="/layout/commonLib.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="${pageContext.request.contextPath }/lang/summernote-ko-KR.js"></script>

 <script>
   $(document).ready(function() {
	   cnt = 1;

       $('#cont').summernote({
    	   height : 350,
           width : 700,
           lang : 'ko-KR',
           toolbar: [
   		    // [groupName, [list of button]]
   		    ['fontname', ['fontname']],
   		    ['fontsize', ['fontsize']],
   		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
   		    ['color', ['forecolor','color']],
   		    ['table', ['table']],
   		    ['para', ['ul', 'ol', 'paragraph']],
   		    ['height', ['height']],
   		    ['insert',['picture','link','video']],
   		    ['view', ['fullscreen', 'help']]
   		  ],
   		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
   		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
        toolbar : false
       });

	   $('#cont').summernote('disable');
       

	   $('#btnAdd').on('click', function(){
			var label = '<label id=label'+cnt+' for=file'+cnt+'>첨부파일'+cnt+' :</label>';
			var files = '<input type="file" id=file'+cnt+' name=file'+cnt+'>';
			$('#filediv').append(label);
			$('#filediv').append(files);
			cnt++;

	   });
	   
	   $('#btnDel').on('click', function(){
			cnt--;
			$('#label'+cnt).remove();
			$('#file'+cnt).remove();

	   });
		   

       
   });

   
 </script>
 
 <style>
 	#postform label{
 		width : 70px;
 	
 	}
 	#datesdiv{
 		text-align : right;
 		display: inline-block;
 		float: right;
 		margin-right: 200px;
 	
 	}
 	#replsubmit{
 		width : 50px;
 		height : 62px;
 		vertical-align: top;
 		
 	}
 	
 
 
 </style>
 
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
</div>

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<fieldset>
				<form id="postform" action="${pageContext.request.contextPath }/postCreate" method="post" enctype="multipart/form-data"  >
				<input type="hidden" name="userid" value="${S_MEMBER.userId }">
				<input type="hidden" name="boardid" value="${boardid }">
				<input type="hidden" name="parentid" value="${parentid }">
				<legend>게시글 조회</legend>
				<label for="title">제 목 : </label>
				<span>${postVo.title }</span>
				<hr>
				<label for="writer">작 성 자 : </label>
				<span>${postVo.userid }</span>
				<div id="datesdiv">
				<label id="dateslabel" for="dates">작성일시 :</label>
				<fmt:formatDate value="${postVo.dates }" pattern="yyyy-MM-dd HH:mm"/>
				</div>			
				<hr>
				<label for="cont">내 용 : </label>				
				<div id="cont" name="cont">${postVo.cont }</div>
				<hr>
				<div id="filediv">
				
				
				</div>
				<button type="button" id="btnUpd">+ 수정</button>
				<button type="button" id="btnDel">- 삭제</button>
				<button type="button" id="btnList">목록</button>
				<button type="button" id="btnAns">답글 작성</button>
				</form>
				
			<%-- 	<!-- 댓글 작성-->
				<p>댓글</p>
				<form id="replForm" action="#" method="post">
				<label for="repltitle">제 목 : </label><br>
				<input type="text" id="repltitle" name="repltitle" value="">
				<br>
				<label for="replcont">내 용 : </label>
				<br>
				<textarea id="replcont" name="replcont" rows="3" cols="80" ></textarea>
				<input id="replsubmit" type="submit" value="등록">
				</form>
				
				<!-- 댓글 목록-->
				
				<c:forEach var=repl items="">
					<label >제 목 : </label><br>
					<input type="text" id="repltitle" name="repltitle" value="">
					<br>
					<label for="replcont">내 용 : </label>
					<br>
					<textarea id="replcont" name="replcont" rows="3" cols="80"></textarea>
				</c:forEach>
				 --%>
				
				
				
				
				
			</fieldset>
		</div>
		
		
		
	</div>
	<!-- /.blog-main -->
</div>	</div>
		</div>
	</div>
</body>
</html>
