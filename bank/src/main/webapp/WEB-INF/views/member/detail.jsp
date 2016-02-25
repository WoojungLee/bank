<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<div id="detail">
		<div class="detailTop">
			<h2>
				<p>detail</p>
				<span>${message} 회원 정보</span>
			</h2>
		</div>
		<div class="detailCenter">

			<fieldset class="detailField">
				<div class="input_row">
					<span class="input_box"> 아이디 : ${member.userid} </span>
				</div>
				<div class="input_row">
					<span class="input_box"> 이름 : ${member.name} </span>
				</div>
				<div class="input_row">
					<span class="input_box"> 비밀번호 : ●●●● </span>
				</div>
				<div class="input_row">
					<span class="input_box"> 주소 : ${member.addr} </span>
				</div>
				<div class="input_row">
					<span class="input_box"> 생년월일 : ${member.birth} </span>
				</div>
				<div class="input_button">
					<span class="input_box"> <input type="button"
						id="detailButton" value="개인정보수정" onclick="updateForm()" />
					</span> <span class="input_box"> <input type="button"
						id="homeButton" value="계좌정보" onclick="account()" />
					</span>
				</div>
				<div>
					<a href="${context}/member/remove/${member.userid}">회원탈퇴</a>
				</div>
				<div>
					<a href="${context}/member/logout">로그아웃</a>
				</div>
			</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function updateForm() {
			location.href = "${context}/member/updateForm";
		}
		function account() {
			location.href = "${context}/account/myAccount/${member.userid}"
		}
	</script>
</body>
</html>