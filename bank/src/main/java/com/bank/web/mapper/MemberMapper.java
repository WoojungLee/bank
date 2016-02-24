package com.bank.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.web.domain.MemberVO;
@Repository
public interface MemberMapper {
	public MemberVO selectMember(MemberVO member);
	public String login(String id, String password);
	public String update(MemberVO member);
	public MemberVO searchById(String id);
	public List<MemberVO> searchByName(String name);
	public String remove(String userid);
	public int countAll();
	public int searchCountByName(String name);
}
