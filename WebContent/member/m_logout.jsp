<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>										<!-- action="logout.out" -->
		<form class="navbar-form navbar-right" action="/Local_my_website1/logout" method="get" onSubmit="CURRENT_URL.value=window.location.href">
			안녕하세요, ${sessionScope.LOGIN_ID}님 &nbsp; &nbsp;
			<input type="hidden" name="CURRENT_URL">
			<button type="submit" class="btn btn-success">로그아웃</button>
		</form>
	</body>
</html>