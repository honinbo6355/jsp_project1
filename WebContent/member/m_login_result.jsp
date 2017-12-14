<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
		<c:choose>
			<c:when test="${param.LOGIN_RESULT=='SUCCESS'}">
				<script>
					alert("로그인이 성공하였습니다.");
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert("로그인이 실패하였습니다.");
				</script>
			</c:otherwise>
		</c:choose>
		<script>
			location.href="${param.CURRENT_URL}";
		</script>
	</body>
</html>