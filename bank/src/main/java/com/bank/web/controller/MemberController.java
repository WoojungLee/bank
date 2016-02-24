package com.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberVO member;
	@Autowired
	MemberService service;

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {

		return "member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("userid") String userid, @RequestParam("password") String password,
			Model model) {
		System.out.println("넘어온 아이디" + userid);
		System.out.println("넘어온 패스워드" + password);
		MemberVO member =  new MemberVO();
		String existId = service.existCheck(userid);
		String message= "", page="";
		if (existId == null) {
			message = "아이디가 존재하지 않습니다.";
			page = "member/loginForm";
		} else {
			member.setUserid(userid);
			member.setPassword(password);
			member = service.login(member);
		
			if (member == null) {
				message = "비밀번호가 일치하지 않습니다.";
				page = "member/loginForm";
			} else {
				message = member.getName();
				page = "account/myAccount";
			}
		}
		
		System.out.println("로그인 후 이름 : " + member.getName());

		return "global/home";

	}

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {

		return "member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@RequestParam("userid") String userid, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("addr") String addr, @RequestParam("birth") String birth,
			Model model) {

		member.setUserid(userid);
		member.setName(name);
		member.setPassword(password);
		member.setAddr(addr);
		member.setBirth(Integer.parseInt(birth));
		System.out.println(userid + name + password + addr + birth);
		int result = service.join(member);
		if (result == 1) {
			System.out.println("회원가입 실패");

		}
		return "member/loginForm";

	}

	@RequestMapping(value = "/logoutForm", method = RequestMethod.GET)
	public String logoutForm(Model model) {

		return "global/home";
	}
}
