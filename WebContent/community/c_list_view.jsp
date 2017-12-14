<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${DTOS=='EMPTY'}">
		<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<td>게시글이 없습니다.</td>
				</tr>
			</thead>
		</table>
			<div>
				<c:if test="${sessionScope.LOGIN_ID!=null}">
					<input type="button" class="btn btn-primary pull-right" onclick="location.href='c_write_view.do'" value="글쓰기">
				</c:if>
			</div>
	</c:when>
	
	<c:otherwise>
		<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>제목</td>
					<td>작성날짜</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dtos" items="${DTOS}">
					<tr>
						<td>${dtos.cNum}</td>
						<td>${dtos.cName}</td>
						<td>
							<a href="c_content_view.do?cId=${dtos.cId}">${dtos.cTitle}</a>
						</td>
						<td>${dtos.cDate}</td>
						<td>${dtos.cHit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div style="text-align:center">
				<a href="c_list.do?PAGE_NUM=1">[맨 앞으로]</a> 
				<a href="c_list.do?PAGE_NUM=${DTO.prev_page_num}">[이전]</a>
				<c:forEach var="i" begin="${DTO.page_snum}" end="${DTO.page_enum}" step="1">
					<c:choose>
						<c:when test="${i == DTO.page_num}">
							<a href="c_list.do?PAGE_NUM=${i}">[${i}]</a>
						</c:when>
						<c:otherwise>
							<a href="c_list.do?PAGE_NUM=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<a href="c_list.do?PAGE_NUM=${DTO.next_page_num}">[다음]</a> 
				<a href="c_list.do?PAGE_NUM=${DTO.total_page}">[맨 뒤로]</a>
				<c:if test="${sessionScope.LOGIN_ID!=null}">
					<input type="button" class="btn btn-primary pull-right" onclick="location.href='c_write_view.do'" value="글쓰기">
				</c:if>	
			</div>
	</c:otherwise>
</c:choose>

