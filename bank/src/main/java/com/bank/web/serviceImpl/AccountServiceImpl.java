package com.bank.web.serviceImpl;

import org.springframework.stereotype.Service;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	int count;
	AccountVO account = new AccountVO();

	/*@Override
	public String open(String name, int password) {
		// 1.통장개설

		account.setName(name);
		account.setPassword(password);
		return account.toString();
	}*/

	@Override
	public String deposit(int money) {
		// 2. 입금
		account.setMoney(money);

		return account.toString();
	}

	@Override
	public String withdraw(int money) {
		// 3. 출금
		
		return (account.getMoney() >= money) ? this.saveMoney(money): "잔액부족";
	}

	private String saveMoney(int money) {
		String result = "";
			account.setMoney(account.getMoney() - money);
			result = "잔액 : " + account.getMoney();
			return result;
	}

	@Override
	public String search() {
		// 4. 잔액조회
		return account.toString();
	}

}
