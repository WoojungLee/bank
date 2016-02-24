package com.bank.web.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;
@Controller
//import bank.AccountBean;

public class MemberController2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberService memberService = new MemberServiceImpl();
		MemberVO member = null;
		List<MemberVO> tmpList = null;

		while (true) {
			System.out.println(
					"원하시는 업무를 선택하세요.\n 1. 회원가입\n 2. 아이디로 회원정보 조회\n 3.이름으로 회원정보 조회\n 4.회원탈퇴\n 5.전체 회원 수 조회\n 6.동명이인 검색\n 7.로그인\n 8.정보수정\n 9.종료");
			switch (scanner.nextInt()) {
			case 1:
				member = new MemberVO();
				System.out.println("이름, 아이디, 비밀번호, 집주소, 생년월일을 입력하세요.");
				member.setName(scanner.next());
				member.setUserid(scanner.next());
				member.setPassword(scanner.next());
				member.setAddr(scanner.next());
				member.setBirth(scanner.nextInt());
				System.out.println(memberService.join(member));
				break;

			case 2:
				System.out.println("아이디를 입력하세요.");
				System.out.println(memberService.searchById(scanner.next()).toString());
				break;
			case 3:
				System.out.println("이름을 입력하세요.");
				tmpList = memberService.searchByName(scanner.next());
				for (int i = 0; i < tmpList.size(); i++) {
					System.out.println(tmpList.toString());
				}
				break;
			case 4:
				System.out.println("아이디를 입력하세요.");
				System.out.println(memberService.remove(scanner.next()));
				break;
			case 5:
				System.out.println("전체 회원수 : " + memberService.countAll());
				break;
			case 6:
				System.out.println("이름을 입력하세요.");
				System.out.println(memberService.searchCountByName(scanner.next()));
				break;
			case 7:
				System.out.println("아이디 패스워드를 입력하세요.");
				//System.out.println(memberService.login(scanner.next(), scanner.next()));
				break;

			case 8:
				System.out.println("변경하고자하는 정보를 입력해주세요.");
				member.setName(scanner.next());
				member.setUserid(scanner.next());
				member.setPassword(scanner.next());
				member.setAddr(scanner.next());
				member.setBirth(scanner.nextInt());
				System.out.println(memberService.update(member));
				break;
			case 9:
				return;

			default:
				System.out.println("숫자를 잘 못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}

		}
	}
}
