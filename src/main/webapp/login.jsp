<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/js.cookie-2.2.1.min.js"></script>

<%-- <%@ include file="/layout/commonLib.jsp" %> --%>
<script>
	$(function(){
		$(Cookies.get("rememberme")=="Y") 
		{
			$("#inputId").val(Cookies.get("userId"));
			$("#rememberme").prop("checked", true);
		}


		$('#submit2').on('click', function(){
			console.log('clicked!');
			var id = "";
			if($('#rememberme').prop('checked')){
				id = $('#inputId').val();
				Cookies.set("rememberme", "Y");
				Cookies.set("userId", id);
			}else{
				Cookies.remove("rememberme");
				Cookies.remove("userId");
			}
			console.log(id);
			$('form').submit();
		})

	})
		



</script>
<style>



</style>
</head>
<body>

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath }/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputId" class="sr-only">ID</label>
        <input type="text" name="userId" id="inputId" value="brown" class="form-control" placeholder="ID" required autofocus/>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pass" id="inputPassword" value="brownPass" class="form-control" placeholder="Password" required/>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberme" value="remember-me"> Remember me
          </label>
        </div>
<!--         <button id="submit" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button> -->
        <input id="submit2" class="btn btn-lg btn-primary btn-block" type="button" value="sign in">Sign in
      </form>
      
<!-- form 태그 안에서 식별자로 submit을 쓰는 경우 submit()메서드가 동작 안함. 
	 form 내부 요소이므로 submit 요소도 전송되는데 이 때 document.form.submit.submit()시 이름 충돌이 일어나 submit()이 실행되지 않음.
	 form 태그 외부에서는 식별자가 submit이어도 전송대상이 아니므로 submit()메서드가 정상 작동.  -->
	 
    </div> <!-- /container -->
  </body>
</html>