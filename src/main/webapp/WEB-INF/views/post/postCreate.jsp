<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="${pageContext.request.contextPath }/lang/summernote-ko-KR.js"></script>

 <script>
   $(document).ready(function() {
	   cnt = 1;
	   maxFileSlot = 5;
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
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
        
       });

	   $('#btnAdd').on('click', function(){
			var label = '<label id=label'+cnt+' for=file'+cnt+'>첨부파일'+cnt+' :</label>';
			var files = '<input type="file" id=file'+cnt+' name="attachfile">';

			if(cnt < maxFileSlot+1){
				$('#filediv').append(label);
				$('#filediv').append(files);
				cnt++;
			}
			else{
				alert("더 이상 파일을 추가할 수 없습니다.\n 파일은 최대 "+maxFileSlot+"개까지 첨부가 가능합니다.");
			}
	   });
	   
	   $('#btnDel').on('click', function(){
			if(cnt > 1){
				cnt--;
			}

			$('#label'+cnt).remove();
			$('#file'+cnt).remove();

	   });
		   

       
   });

   
 </script>			

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<fieldset>
				<legend>게시글 작성</legend>
				<form id="postform" action="${pageContext.request.contextPath }/postCreate" method="post" enctype="multipart/form-data"  >
				<input type="hidden" name="userid" value="${S_MEMBER.userId }">
				<input type="hidden" name="boardid" value="${post.boardid }">
				<input type="hidden" name="parentid" value="${post.parentid }">
				<label for="title">제 목 : </label>
				<input type="text" id="title" name="title" autofocus>
				<br><br>
				<label for="cont">내 용 : </label>				
				<textarea id="cont" name="cont"></textarea>
				<br>
				<div id="filediv">
				</div>
				<button type="button" id="btnAdd">+ 추가</button>
				<button type="button" id="btnDel">- 제거</button>
				<input type="submit" value="등록">
				</form>
			</fieldset>
		</div>
		
		
		
	</div>
	<!-- /.blog-main -->
</div>
