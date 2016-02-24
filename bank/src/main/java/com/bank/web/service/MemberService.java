package com.bank.web.service;

import java.util.List;

import com.bank.web.domain.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO member);
	public String update(MemberVO member);
	public int join(MemberVO member);
	public MemberVO searchById(String id);
	public List<MemberVO> searchByName(String name);
	public String remove(String userid);
	public int countAll();
	public int searchCountByName(String name);
	public String existCheck(String userid);
}
