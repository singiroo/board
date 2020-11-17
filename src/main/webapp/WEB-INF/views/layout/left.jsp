<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-sidebar">
		<h4 align="center"><b>** 메뉴 **</b></h4>
		<li class="active"><a href="${pageContext.request.contextPath }/Main">Main <span class="sr-only">(current)</span></a></li>
		<%-- <li class="active"><a href="${pageContext.request.contextPath }/memberList?pageSize=8">사용자 관리</a></li> --%>
		<li class="active"><a href="${pageContext.request.contextPath }/boardManage">게시판 관리</a></li>
		<h4 align="center"><b>** 게시판 목록 **</b></h4>
		<c:forEach items="${S_BOARDLIST }" var="board">
			<li class="active" data-userid="${board.userid }"><a href="${pageContext.request.contextPath }/postList?boardid=${board.boardid}">${board.boardnm }</a></li>
		</c:forEach>	
</ul>

