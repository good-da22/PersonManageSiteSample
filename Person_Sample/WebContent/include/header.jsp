<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<c:if test="${ empty sessionScope.userinfo }">
		<div>
			<form method="post" action="${ root }/user">
				<input type="hidden" name="action" value="login">
				<label>아이디 <input type="text" id="userid" name="userid"></label>
				<label>비밀번호 <input type="password" id="userpwd" name="userpwd"></label>
				
				<input type="submit" id="login" value="로그인">
			</form>
			
			<script>
				<c:if test="${!empty message}">
					alert("${message}");
				</c:if>
			</script>
		</div>
	</c:if>
</div>