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

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
		<div>
			<c:if test="${ !empty list }">
				<table>
					<thead>
						<tr>
							<td>아이디</td>
							<td>이름</td>
							<td>부서 명</td>
							<td>급여</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ list }" var="person">
							<tr>
								<td><a href="${ root }/main?action=detail&personid=${ person.id }">${ person.id }</a></td>
								<td>${ person.name }</td>
								<td>${ person.departmentName }</td>
								<td>${ person.pay }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>		
			</c:if>
			<c:if test="${ empty list }">
				<h1>등록된 명단이 없습니다.</h1>
			</c:if>
		</div>
		
		<div>
			<a href="${root}">메인 화면으로 이동</a>
		</div>
	
	</div>

<%@ include file="/include/footer.jsp" %>