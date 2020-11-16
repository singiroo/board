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
	   isUpdMode = false;
		// 펑션으로 묶자.
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

	   $('#btnUpd').on('click', function(){
    		//console.log("update!!");
   			document.location = "${pageContext.request.contextPath}/postUpdate?postid=${map.postVo.postid}"
			
		})



	   
	   $('#btnDel').on('click', function(){
			var ask_del = confirm("이 글을 삭제하시겠습니까?");
			if(ask_del == true){
				document.location = "${pageContext.request.contextPath}/deletePost?postid=${map.postVo.postid}&boardid=${map.postVo.boardid }";
			}

	   });


		$('button.downBtn').on('click', function(){
			var fileid = $(this).prev().data('fileid');
			document.location = "${pageContext.request.contextPath}/download?fileid="+fileid;
		});


		$('#btnAns').on('click', function(){
			var parentid = "${map.postVo.postid}";
			var boardid = "${map.postVo.boardid}";
			document.location = "${pageContext.request.contextPath}/postCreate?parentid="+parentid+"&boardid="+boardid;
		});


		$('button.replUpd').on('click', function(){
			if(isUpdMode == false){
				$(this).parents('table').prev().removeAttr('readonly').focus();
				$(this).parents('table').find('button.replDel').text('취소');
				isUpdMode = true;
			}
			else{
				$(this).parents('form.replListForm').submit();
			}

		});



		$('button.replDel').on('click', function(){
			//삭제 모드
			if(isUpdMode == false){
				var replid = $(this).parents('li.replList-li').find('input[type=hidden]').val();
				document.location = "${pageContext.request.contextPath}/replDelete?replid="+replid;
			}
			//취소 모드
			else{
				var postid = "${map.postVo.postid}";
				document.location = "${pageContext.request.contextPath}/post?postid="+postid;
			}
		});

		$('#btnList').on('click', function(){
			var boardid = "${map.postVo.boardid }";
			document.location = "${pageContext.request.contextPath}/postList?boardid="+boardid;

		})
			
		   

       
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
 		vertical-align: text-top;
 		
 	}
 	
 	div.filename{
 		display : inline-block;
 		width : 200px;
 		height : 30px;
 	}
 		
 	#replcont{
 		vertical-align: text-top;
 	
 	}
 	
 	#allUserBtn{
 		display : inline-block;
 		float : right;
 		margin-right : 150px;
 	}
 	
 	label.repllabel{
 		float: right;
 		margin-right : 150px;
 	
 	}
 	
 	ul{
 		list-style: none;
 	}
 	
 	
 	button.replUpd,button.replDel{
 		width : 50px;
 		height : 22px;
 		vertical-align: text-top;
 	}
 	#btnTable{
 		display : inline-block;
 	}
 	
 	hr{
 		width : 83%;
 		margin-left : 0;
 	}
 	#title{
 		font-size : 18px;
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
					
	
				<div class="blog-header"></div>
	
				<div class="row">
				
					<div class="col-sm-8 blog-main">
				
						<div class="blog-post">
							<fieldset>
								<legend>게시글 조회</legend>
								<form id="postform" action="${pageContext.request.contextPath }/postCreate" method="post" enctype="multipart/form-data"  >
								<input type="hidden" name="userid" value="${S_MEMBER.userId }">
								<input type="hidden" name="boardid" value="${map.postVo.boardid }">
								<input type="hidden" name="parentid" value="${map.postVo.parentid }">
								<label for="title">제 목 : </label>
								<span id="title">${map.postVo.title }</span>
								<hr>
								<label for="writer">작 성 자 : </label>
								<span>${map.postVo.userid }</span>
								<div id="datesdiv">
									<label id="dateslabel" for="dates">작성일시 :</label>
									<fmt:formatDate value="${map.postVo.dates }" pattern="yyyy-MM-dd HH:mm"/>
								</div>			
								<hr>
								<label for="cont">내 용 : </label>				
								<div id="cont">${map.postVo.cont }</div>
								<hr>
								<ul class="fileList">
									<c:forEach items="${map.fileList }" var="file" varStatus="status" >
										<li class="file-li">
											<div class="filename" data-fileid="${file.fileid }">첨부파일 ${status.index+1 } : ${file.realfilename }</div>
											<button type="button" class="downBtn">다운로드</button>
										</li>
									</c:forEach>				
								</ul>
								</form>
								<hr>
								<c:choose>
									<c:when test="${S_MEMBER.userId == map.postVo.userid }">
										<button type="button" id="btnUpd">+ 글 수정</button>
										<button type="button" id="btnDel">x 글 삭제</button>
									</c:when>
								</c:choose>
								
								<div id="allUserBtn">
									<button type="button" id="btnList">목록</button>
									<button type="button" id="btnAns">답글 작성</button>				
								</div>				
				
							 	<!-- 댓글 작성-->
							 	<hr>
								<p>댓글</p>
								<form id="replForm" action="${pageContext.request.contextPath }/replCreate" method="post">
									<input type="hidden" name="userid" value="${S_MEMBER.userId}">
									<input type="hidden" name="postid" value="${map.postVo.postid}">
									<label for="repltitle">제 목 : </label>
									<input type="text" id="repltitle" name="title" value="">
									<br>
									<label for="replcont">내 용 : </label>
									<textarea id="replcont" name="cont" rows="3" cols="80" ></textarea>
									<input id="replsubmit" type="submit" value="등록">
								</form>
								<hr>
								<!-- 댓글 목록-->
								 <ul id="replList">
									<c:forEach var="repl" items="${map.replList}" varStatus="status">
										<li class="replList-li">
											<form class="replListForm" action="${pageContext.request.contextPath }/replUpdate" method="post">
												<input type="hidden" name="replid" value="${repl.replid}">
												<label>${status.index+1 }.</label>
												<c:choose>
													<c:when test="${repl.status=='T'}">
														<label >${repl.title }</label>									
													</c:when>
													<c:otherwise>
														<label >[삭제된 댓글입니다]</label>																		
													</c:otherwise>
												</c:choose>
												<label class="repllabel">작성일시 : <fmt:formatDate value="${repl.dates }" pattern="yyyy-MM-dd HH:mm"/></label>
												<br>
												<label class="repllabel">작성자 : ${repl.userid }</label>
												<br>
												<c:if test="${repl.status=='T'}">
													<textarea class="replcont" name="cont" rows="2" cols="80" readonly>${repl.cont }</textarea>
													<c:choose>
														<c:when test="${S_MEMBER.userId == repl.userid }">
														<table id="btnTable">
															<tr><td><button type="button" class="replUpd">수정</button></td></tr>
															<tr><td><button type="button" class="replDel">삭제</button></td></tr>								
														</table>
														</c:when>
													</c:choose>
												</c:if>
											</form>
										</li>
										<br>
									</c:forEach>				
								</ul><!-- replList  -->
							</fieldset>
						</div><!-- blog-post  -->
					</div><!-- /.blog-main -->
				</div><!-- row  -->
			</div><!-- main  -->
		</div><!-- row  -->
	</div><!-- container-fluid  -->
</body>
</html>
