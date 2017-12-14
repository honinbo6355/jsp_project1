<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<title>
  		My Website
  	</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩 101 템플릿</title>

    <!-- 부트스트랩 -->
    <link href="../Resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../Resources/sticky-footer.css" rel="stylesheet">
  </head>
  
  <body>
    
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../Web_home.jsp">My Website</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
          </ul>
			<c:choose>
				<c:when test="${sessionScope.LOGIN_ID==null}">
					<jsp:include page="/member/m_login.html"/>
				</c:when>
			<c:otherwise>
					<jsp:include page="/member/m_logout.jsp"/>
				</c:otherwise>
			</c:choose>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<div class="container-fluid">
      <div class="row">
        <div class="col-md-2 sidebar">
          <ul class="nav nav-pills nav-stacked">
          	<li style="text-align:center"><h4>My Portfolio</h4></li><br>
          	
            <li class="active"><a href="c_list.do">커뮤니티 <span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-md-8">
        	<jsp:include page="${param.BODY_PATH}"/>
        </div>
        <div class="col-md-2">
        
        </div>
      </div>
    </div>
    	
    <footer class="footer">
		<div class="container">
			<p class="text-muted">Copyright(c) 2017 송세일 All rights reserved </p>
		</div>
	</footer>
	<script>
		
	</script>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="../Resources/js/bootstrap.min.js"></script>
  </body>
</html>