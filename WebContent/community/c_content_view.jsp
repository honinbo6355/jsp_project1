<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped table-bordered" style="text-align:center; border: 1px solid #dddddd">
	<tbody>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">번호</td>
			<td>${C_DTO.cNum}</td>
		</tr>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">아이디</td>
			<td>${C_DTO.cName}</td>
		</tr>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">제목</td>
			<td>${C_DTO.cTitle}</td>
		</tr>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">내용</td>
			<td style="word-break: break-all; padding-left:100px; padding-right:100px;">${C_DTO.cContent}</td>
		</tr>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">작성날짜</td>
			<td>${C_DTO.cDate}</td>
		</tr>
		<tr>
			<td style="width:100px; min-width:100px; max-width:100px">조회수</td>
			<td>${C_DTO.cHit}</td>
		</tr>
		<tr>
			<td colspan="2">
				<div style="text-align: left;">
					<c:if test="${sessionScope.LOGIN_ID==C_DTO.cName}">
						<input type="button" class="btn btn-default" onclick="location.href='c_modify_view.do?cId=${C_DTO.cId}'" value="글수정">
						<input type="button" class="btn btn-default" onclick="delete_check();" value="글삭제">
					</c:if>
					<input type="button" class="btn btn-default pull-right" onclick="location.href='c_list.do'" value="목록으로">
				</div>
			</td>
		</tr>
	</tbody>
</table>
<hr>

<table class="table table-striped table-bordered" style="text-align:left; border: 1px solid #dddddd">
	<tbody>
		<c:if test="${DTOS!='EMPTY'}">
			<c:forEach var="dtos" items="${DTOS}">
				<tr>
					<td>${dtos.rName}<br><br><div style="font-size:13px;">${dtos.rDate}</div></td>
					<td style="word-break: break-all;">
						<c:forEach begin="1" end="${dtos.rIndent}">&nbsp; &nbsp; &nbsp; &nbsp;</c:forEach>
						<c:if test="${dtos.rIndent != 0}"><img src="../Resources/image/canva-reply-icon-MACYAmx31rk.png" style="width:25px; height:20px;"/></c:if>
					${dtos.rContent}
					</td>
					<td>
						<c:if test="${sessionScope.LOGIN_ID!=null}">
							<input type="button" class="btn btn-default" value="답변" onclick="answer_open(${dtos.rNum})">
						</c:if>
						<c:if test="${dtos.rName == sessionScope.LOGIN_ID}">
							<input type="button" class="btn btn-default" value="삭제">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${sessionScope.LOGIN_ID!=null}">
			<tr>
				<form action="r_reply.do" method="post">
					<input type="hidden" name="rGroup" value="${C_DTO.cId}">
					<input type="hidden" name="rName" value="${sessionScope.LOGIN_ID}">
					<td style="width:150px; min-width:150px; max-width:150px;">${sessionScope.LOGIN_ID}</td>
					<td><textarea name="rContent" class="form-control" rows="4" cols="70"></textarea></td>
					<td><input type="submit" class="btn btn-default" value="등록"></td>
				</form>
			</tr>
		</c:if>
	</tbody>
</table>
	<script>
		function delete_check() {
			if (confirm("정말 삭제하시겠습니까?") === true) {
				location.href = "c_delete.do?cId=" + ${C_DTO.cId};
			}
			else {
				return;
			}
		}
		
		function answer_open(rNum) {
			var url = "r_answer_view.do?rNum="+rNum;
			var name = "answerForm";
			var specs = "width=400,height=250";
			window.open(url, name, specs);
		}
		
	</script>
