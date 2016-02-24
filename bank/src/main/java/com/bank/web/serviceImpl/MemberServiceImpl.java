package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberVO member;
	private int count = 0;
	private MemberVO[] members;
	private Map<String, MemberVO> map;
	//@Autowired MemberMapper mapper;
	@Autowired private SqlSession sqlSession;

	public MemberServiceImpl() {
		//member = new MemberVO();
		map = new HashMap<String, MemberVO>();
	}
	/*
	 * public MemberServiceImpl(int count) { // 생성자 member = new MemberBean();
	 * members = new MemberBean[count]; map = new HashMap<String, Object>(); }
	 */

	@Override
	public MemberVO login(MemberVO member) {

		if(sqlSession == null){
			System.out.println("세션이 널값");
		}else{
			System.out.println("세션이 널값 아님");
		}
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		member= mapper.selectMember(member);
		System.out.println("서비스단 " + member.getName());
		/*String result = "로그인 실패";
		// 메소드 체인 기법

		if (map.containsKey(id)) { // 맵에 id가 존재하는 지를 먼저 체크한다.
			result = ((map.get(id)).getPassword().equals(password) ? "로그인 성공" : "로그인 실패");
		}*/
		return member;
	}

	public String update(MemberVO member) {
		// TODO Auto-generated method stub
		searchById(member.getUserid());

	//	map.replace(member.getUserid(), member);
		return "업데이트 성공";

		/*
		 * for (int i = 0; i < members.length; i++) {
		 * members[i].setName(member.getName());
		 * members[i].setUserid(member.getUserid());
		 * members[i].setPassword(member.getPassword());
		 * members[i].setAddr(member.getAddr());
		 * members[i].setBirth(member.getBirth()); }
		 */
	}

	public int getCount() {
		return count;
	}

	@Override
	public String join(MemberVO member) {
		// 회원가입
		map.put(member.getUserid(), member);
		count++;
		return member.getName() + "님 회원가입이 완료되었습니다.";
	}

	@Override
	public MemberVO searchById(String id) {
		// 아이디로 회원정보 검색

		return map.get(id);

	}

	@Override
	public List<MemberVO> searchByName(String name) {
		// 이름으로 회원정보 검색
		
		List<MemberVO> tempList = new ArrayList<MemberVO>();
		for (String id :map.keySet()) {
			if (map.get(id).getName().equals(name)) {
				tempList.add(map.get(id));
			}
		}
		return tempList;
	}

	@Override
	public String remove(String userid) {
		// 회원탈퇴
		// AccountBean account = null;
		// String closeResult = "";
		// 이 라인에서 account 는 인스턴스 개념이 아니라
		// 리턴을 받는 타입의 변수이다.
		/*
		 * if (this.searchById(userid) != null) { for (int i = 0; i <
		 * this.getCount(); i++) { if (members[i].getUserid() == userid) {
		 * members[i] = members[this.getCount() - 1]; members[this.getCount() -
		 * 1] = null; } } count--; closeResult = userid + " 계정이 정상적으로 삭제되었습니다.";
		 * } else { closeResult = "해당 아이디가 존재하지 않습니다."; }
		 */
		return map.remove(userid) != null ? "탈퇴성공" : "탈퇴실패";
	}

	@Override
	public int countAll() {
		// 전체 회원 수 조회
		return this.getCount();
	}

	@Override
	public int searchCountByName(String name) {
		// 동명이인 수 검색
		// TODO Auto-generated method stub
		int tempCount = 0;
		for (int i = 0; i < map.size(); i++) {
			if (members[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}


}
