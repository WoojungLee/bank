package com.bank.web.mapper;

import com.bank.web.domain.AccountVO;

public interface AccountMapper {

	AccountVO selectAccount(String userid);
	
}
