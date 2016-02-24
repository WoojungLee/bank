<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<div id="join">
		<div class="joingTop">
			<h2>
				<p>JOIN</p>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="loginCenter">
			<form action="/member/join" method="get" name="joinForm">
				<fieldset class="joinField">
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="userid" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="name" placeholder="이름"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="password" id="password" placeholder="패스워드" maxlength="20"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="addr" placeholder="주소"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="date" id="birth" placeholder="생년월일"/>
						</span>
					</div>
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="joinButton" value="회원가입"/>
						</span>
						<span class="input_box">
							<input type="button" id="cancleButton" value="취소"/>
						</span>
					</div>
			
				</fieldset>

			</form>
		</div>
	</div>
</body>
</html>