<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<div id="update">
		<div class="updateTop">
			<h2>
				<p>update</p>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="updateCenter">
			<form action="${context}/member/update" method="get" name="updateForm">
				<fieldset class="updateField">
					<div class="input_row">
						<span class="input_box">
							아이디 : ${member.userid}
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
								이름 : ${member.name}
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							비밀번호 : <input type="password" id="password" name="password" value="${member.password}"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							주소 : <input type="text" id="addr" name="addr" value="${member.addr}"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							생년월일  : ${member.birth}
						</span>
					</div>
					<div class="input_button">
						<span class="input_box">
							<input type="submit" id="confirmButton" value="확 인" onclick="updateMember()"/>
						</span>
						<span class="input_box">
							<input type="reset" id="cancleButton" value="취소" onclick="cancel()"/>
						</span>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function cancel(){
			location.href="${context}/member/detail";
		}
		function updateMember(){
			document.updateForm.submit();
		}
	</script>
</body>
</html>