package com.bank.web.mapper;

import java.util.List;

import com.bank.web.domain.MemberVO;

public interface MemberService {
	public String join(MemberVO member);
	public MemberVO searchById(String id);
	public List<MemberVO> searchByName(String name);
	public String remove(String userid);
	public int countAll();
	public int searchCountByName(String name);
	public MemberVO login(MemberVO member);
	public String update(MemberVO member);

}
