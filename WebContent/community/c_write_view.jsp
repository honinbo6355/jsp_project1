<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form name="writeForm" action="c_write.do" method="post">
	<table class="table table-striped table-bordered" style="text-align:center; border: 1px solid #dddddd">
		<input type="hidden" name="cName" value="${sessionScope.LOGIN_ID}">
		<tbody>
			<tr>
				<td style="width:80px">제목</td>
				<td><input type="text" class="form-control" name="cTitle" placeholder="제목을 입력하세요." maxlength="100"></td>
			</tr>
			<tr>
				<td style="width:80px">내용</td>
				<td><TEXTAREA class="form-control" ROWS=10 NAME="cContent" placeholder="내용을 입력하세요." maxlength="300"></TEXTAREA></td>
			</tr>
		</tbody>
	</table>
	<div style="text-align: left;">
			<input type="submit" class="btn btn-default" value="확인" onclick="return write_check();"> 
			<input type="reset" class="btn btn-default" value="취소">
			<input type="button" class="btn btn-default pull-right" onclick="location.href='c_list.do'" value="목록으로">
	</div>
</form>
	<script>
		function write_check(){
			var writeForm = document.writeForm;
			if(writeForm.cTitle.value==""){
				alert("제목을 입력하세요.");
				writeForm.cTitle.focus();
				return false;
			}
			else if(writeForm.cContent.value==""){
				alert("내용을 입력하세요.");
				writeForm.cContent.focus();
				return false;
			}
		}
	</script>
</body>
</html>