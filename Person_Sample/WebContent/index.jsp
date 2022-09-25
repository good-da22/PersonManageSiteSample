<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	
	<%@ include file="/include/header.jsp" %>

	<c:if test="${ !empty sessionScope.userinfo }">
		<div>
			${ userinfo.userId } 님 환영합니다.
		</div>
		<div>
			<a href="${ root }/user?action=logout">로그아웃</a>
		</div>
	</c:if>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
		안녕하세요. 인사 관리 사이트 입니다.
	
	
	</div>

<%@ include file="/include/footer.jsp" %>