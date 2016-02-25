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
		MemberVO temp = new MemberVO();
		if(sqlSession == null){
			System.out.println("세션이 널값");
		}else{
			System.out.println("세션이 널값 아님");
		}
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		System.out.println("서비스 아이디 파람값 : "+member.getUserid());
		System.out.println("서비스 아이디 파람값 : "+member.getPassword());
		temp = mapper.selectMember(member);
		System.out.println("서비스단 결과값 아이디 " + temp.getUserid());
		System.out.println("서비스단 결과값 이름 " + temp.getName());
		
		return temp;
		/*String result = "로그인 실패";
		// 메소드 체인 기법

		if (map.containsKey(id)) { // 맵에 id가 존재하는 지를 먼저 체크한다.
			result = ((map.get(id)).getPassword().equals(password) ? "로그인 성공" : "로그인 실패");
		}*/
		
	}

	public int update(MemberVO member) {
		// TODO Auto-generated method stub
		//	map.replace(member.getUserid(), member);
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.update(member);

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
	public int join(MemberVO member) {
		// 회원가입
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		
		return mapper.insertMember(member);
	}

	@Override
	public MemberVO searchById(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.selectMemberById(id);

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
	public int remove(String userid) {
		// 회원탈퇴
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.deleteMember(userid);
		
		//return map.remove(userid) != null ? "탈퇴성공" : "탈퇴실패";
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

	@Override
	public String existCheck(String userid) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		return mapper.selectUserid(userid);
	}


}
