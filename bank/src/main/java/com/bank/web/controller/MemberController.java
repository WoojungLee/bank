package com.bank.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.org.apache.xerces.internal.util.Status;

@Controller
@SessionAttributes("member")
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
			HttpSession session,
			Model model) {
		System.out.println("넘어온 아이디" + userid);
		System.out.println("넘어온 패스워드" + password);
		MemberVO member =  new MemberVO();
		String existId = service.existCheck(userid);
		String message= "", page="";
		if (existId == null) {
			message = "아이디가 존재하지 않습니다.";
			page = "member/loginForm";
		}else{
			member.setUserid(userid);
			member.setPassword(password);
			member = service.login(member);
			if (member == null) {
				message = "비밀번호가 일치하지 않습니다.";
				page = "member/loginForm";
			} else {
				
				message = member.getName();
				session.setAttribute("member", member);
				model.addAttribute("message",message);
				page = "account/myAccount";
				System.out.println("로그인 후 message : " + message);
			}
			
		}
		

		return page;

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

/*	@RequestMapping(value = "/logoutForm", method = RequestMethod.GET)
	public String logoutForm(Model model) {
 
		return "global/home";
	}*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "global/home";
	}

	@RequestMapping(value="/updateForm", method = RequestMethod.GET)
	public String updateForm(){
		
		return "member/updateForm";
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(
			@RequestParam("password") String password,
			@RequestParam("addr") String addr,
			HttpSession session,
			Model model) {
		MemberVO temp = new MemberVO();
		temp = (MemberVO)session.getAttribute("member");
		System.out.println("화면에서 넘어온 비번" + temp.getPassword());
		System.out.println("세션에 있는 아이디 " +  temp.getUserid());
		member.setUserid(temp.getUserid());
		member.setPassword(password);
		member.setAddr(addr);
		System.out.println(password + addr);
		int result = service.update(member);
		String page = "";
		if (result == 1) {
			temp.setPassword(password);
			temp.setAddr(addr);
			session.setAttribute("member", temp);
			page = "member/detail";
		}else{
			System.out.println("회원 수정 실패");
			page = "member/updateForm";
		}
		return page;

	}
	@RequestMapping(value="/remove/{userid}", method = RequestMethod.GET)
	public String remove(HttpSession session, SessionStatus status){
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		String userid = temp.getUserid();
		int result = service.remove(userid);
		System.out.println("remove");
		String page = "";
		if (result == 1) {
			System.out.println("회원 삭제 성공");
			status.setComplete();
			page = "global/home";
		}else{
			System.out.println("회원 삭제 실패");
			page = "account/detail";
		}
		return page;
		
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(Model model){
		
		return "member/detail";
		
	}
}
