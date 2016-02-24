package com.bank.web.serviceImpl;

import org.springframework.stereotype.Service;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	// private AccountBean[] accounts = new AccountBean[100];
	private AccountVO[] accounts;
	private int count = 0; // 멤버변수이지만 초기값이 필요한 경우에는
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public AdminServiceImpl(int count) {
		accounts = new AccountVO[count];
	}

	public AccountVO[] getAccounts() {
		return accounts;
	}

	public void setAccounts(AccountVO[] accounts) {
		this.accounts = accounts;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count += count;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return this.getCount();
	}

	@Override
	public AccountVO searchAccountByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		AccountVO account = null;
		// 이 라인에서 account 는 인스턴스 개념이 아니라
		// 리턴을 받는 타입의 변수이다.
		for (int i = 0; i < this.getCount(); i++) {
			if (accounts[i].getAccountNo() == accountNo) {
				account = accounts[i];
			}
		}
		return account;
	}

	@Override
	public AccountVO[] searchAccountByName(String name) {
		// 3. 이름으로 계좌정보조회o
		AccountVO[] tempList = new AccountVO[this.searchCountByName(name)];
		int j = 0;
		for (int i = 0; i < this.getCount(); i++) {

			if (accounts[i].getName().equals(name)) {
				tempList[j] = accounts[i];
				j++;
			}
			/*
			 * for (int i = 0; i < tempList.length; i++) {
			 * System.out.println(""); }
			 */ }
		return tempList;
	}

	@Override
	public String closeAccount(int accountNo) {
		// TODO Auto-generated method stub
		//AccountBean account = null;
		String closeResult = "";
		// 이 라인에서 account 는 인스턴스 개념이 아니라
		// 리턴을 받는 타입의 변수이다.
		if ( this.searchAccountByAccountNo(accountNo) != null) {
			for (int i = 0; i < this.getCount(); i++) {
				if (accounts[i].getAccountNo() == accountNo) {
					accounts[i] = accounts[this.getCount() - 1];
					accounts[this.getCount() - 1] = null;
				}
			}
			this.setCount(this.getCount() - 1);
			closeResult = accountNo + " 계좌가 정상적으로 삭제되었습니다.";
		} else {
			closeResult = "해당 계좌가 존재하지 않습니다.";
		}
		return closeResult;

	}

	@Override
	public int searchCountByName(String name) {
		// TODO Auto-generated method stub
		int tempCount = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if (accounts[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}

	@Override
	public String open(String name, int password) {
		// TODO Auto-generated method stub
		// account 인스턴스를 필드에 선언하면
		// 나중에 추가되는 값을 어버라이딩(덮어쓰기) 하게 된다.
		// 추가되는 개념으로 코딩하려면 지역변수로 처리하고
		// 자료구조(컬렉션)를 필드에 선언해야 한다.
		AccountVO account = new AccountVO();
		account.setName(name);
		account.setPassword(password);
		accounts[count] = account;
		count++;
		return account.toString();
	}

}
