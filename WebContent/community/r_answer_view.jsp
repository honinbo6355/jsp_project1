<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>
			
		</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	
    	<link href="../Resources/css/bootstrap.min.css" rel="stylesheet">
    	<link href="../Resources/sticky-footer.css" rel="stylesheet">
	</head>	
	<body>
		<div>
			<div style="text-align:center">댓글 답변</div>
			<hr/>
			<div>
			 	<form action="r_answer.do" method="post">
			 		<input type="hidden" name="rParent" value="${DTO.rParent}">
			 		<input type="hidden" name="rGroup" value="${DTO.rGroup}">
			 		<input type="hidden" name="rStep" value="${DTO.rStep}">
			 		<input type="hidden" name="rIndent" value="${DTO.rIndent}">
			 		<input type="hidden" name="rName" value="${sessionScope.LOGIN_ID}">
			 		
			 		<textarea rows="4" cols="50" name="rContent" class="form-control"></textarea><br>
			 		<input type="submit" class="btn btn-default" value="확인">
			 		<input type="reset" class="btn btn-default" value="취소">
			 	</form>
			</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	    <script src="../Resources/js/bootstrap.min.js"></script>
	</body>
</html>