package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AdminServiceImpl;
@Controller
public class AdminController {
	public static void main(String[] args) {
		AdminService adminService = new AdminServiceImpl(100);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("업무선택 :\n 1.전체 계좌 수 조회\n 2.계좌번호로 조회\n 3.이름으로 조회\n 4.계좌삭제\n 5.동일인 계좌수 조회\n 6.계좌개설\n 9.종료");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("총 계좌 수 : " + adminService.countAll());				
				break;
			case 2:
				System.out.println("조회하려는 계좌번호 입력 : ");
				System.out.println("조회한 계좌 : " + adminService.searchAccountByAccountNo(scanner.nextInt()).toString());
				break;
			case 3:
				System.out.println("조회하려는 이름 입력 : ");
				System.out.println();
				AccountVO[] accounts = adminService.searchAccountByName(scanner.next());
				for (int i = 0; i < accounts.length; i++) {
					System.out.println(accounts[i]);
				}
				break;
			case 4:
				System.out.println("삭제하려는 계좌번호 입력 :");
				System.out.println(adminService.closeAccount(scanner.nextInt()));
				break;
			case 5:
				System.out.println("조회하려는 이름 입력 : ");
				System.out.println(adminService.searchCountByName(scanner.next()));
				break;
			case 6:
				System.out.println("이름, 비번");
				System.out.println(adminService.open(scanner.next(), scanner.nextInt()));
				break;
			case 9:
				return;
			default:
				System.out.println("1~5번 사이에서 선택 가능합니다.");
				break;
			}
		}
	}
}
