package com.newlecture.homwork;

import java.util.Scanner;

public class Wallet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int balance = 0;
		int inmoney, outmoney;
		int close = 0;


		while (true) {
			System.out.println("<내 지갑>");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 통장 잔고 확인");
			System.out.println("4. 종료");
			System.out.print("선택 :");
			int menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.print("입금할 금액 :");
				inmoney = scan.nextInt();
				balance += inmoney;
				break;

			case 2:
				System.out.print("출금할 금액 :");
				outmoney = scan.nextInt();
				balance -= outmoney;
				if ( balance<0 ) {
					System.out.println("잔액이 부족합니다.");
					balance += outmoney;
					break;
				}
				break;

			case 3:
				System.out.printf("통장 잔고 확인 : %d\n", balance);
				break;

			case 4:
				close = 1;
				break;

			default:
				System.out.println("1~4 숫자를 입력하세요.");
				break;
			}

			if ( close == 1)
			break;
		}
		System.out.println("종료되었습니다.");

	}

}
