package com.bank.web.domain;

import org.springframework.stereotype.Component;

@Component
public class AccountVO {
	// 멤버필드(멤버변수를 정의한 영역)
	// 멤버변수는 초기화를 하기 않는다. 지역변수와의 차의점
	// 멤버변수는 메소드 밖에 위치하며 메소드 사이에서 값을 공유한다.
	// POJO plain old java object
	public static String BANK = "한빛뱅크";
	private int accountNo;
	private String name;
	private int money;
	private int password;
	private String msg;

	// 멤버 메소드 에어리어 (멤버메소드를 정의한 영역)
	public AccountVO() { // 생성자
		// TODO Auto-generated constructor stub
		// 4자리 수의 랜덤한 숫자
		this.accountNo = (int) (Math.random() * 8999) + 1000;
	}

	// 멤변에 값을 입력하고, 조회할 수 있는 메소드인 getter/setter 생성
	// 단축키 alt + shift + s + r
	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+ BANK + "]" + this.name + " : " +  "계좌 : " + this.accountNo +" 잔고 : " + this.money + "원"
				+ " 비밀번호 : ****" ;
	}

}
