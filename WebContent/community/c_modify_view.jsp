<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form name="modifyForm" action="c_modify.do" method="post">
	<table class="table table-striped table-bordered" style="text-align:center; border: 1px solid #dddddd">
		<input type="hidden" name="cId" value="${DTO.cId}">
		<tbody>
			<tr>
				<td>번호</td>
				<td>${DTO.cNum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="cTitle" maxlength="100" value="${DTO.cTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><TEXTAREA class="form-control" COLS=80 ROWS=10 NAME="cContent" maxlength="300">${DTO.cContent}</TEXTAREA></td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td>${DTO.cDate}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${DTO.cHit}</td>
			</tr>
		</tbody>
	</table>
	<div style="text-align: left;">
		<input type="submit" class="btn btn-default" value="확인" onclick="return modify_check()"> 
		<input type="reset" class="btn btn-default" value="취소">
		<input type="button" class="btn btn-default pull-right" onclick="location.href='c_list.do'" value="목록으로">
	</div>
</form>
	<script>
		function modify_check(){
			var modifyForm = document.modifyForm;
			if(modifyForm.cTitle.value==""){
				alert("제목을 입력하세요.");
				modifyForm.cTitle.focus();
				return false;
			}
			else if(modifyForm.cContent.value==""){
				alert("내용을 입력하세요.");
				modifyForm.cContent.focus();
				return false;
			}
		}
	</script>