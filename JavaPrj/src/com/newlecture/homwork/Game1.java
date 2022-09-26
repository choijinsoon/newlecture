package com.newlecture.homwork;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int balance = 0;
		int inmoney, outmoney;
		int close1 = 0, close2 = 0;

		int choose;
		int betmoney = 0;

		while (true) {
			System.out.println("===========|Game1|===========");
			System.out.println("1. 게임시작");
			System.out.println("2. 게임안내");
			System.out.println("3. 내 통장 이동");
			System.out.println("4. 종료");
			System.out.print("선택 :");
			int menu1 = scan.nextInt();

			switch (menu1) {
			case 1:
				Random rand1 = new Random();
				int answer = rand1.nextInt(2) + 1;

				System.out.println("게임을 시작합니다.");
				System.out.print("숫자 입력 (홀:1 / 짝:2) :");
				choose = scan.nextInt();
				while (choose == 1 || choose == 2) {
					System.out.printf("배팅 금액: ");
					betmoney = scan.nextInt();
					balance -= betmoney;
					if (balance < 0) {
						System.out.println("잔액이 부족합니다.");
						balance += betmoney;
					} else {
						System.out.println("배팅 완료!");

						if (choose == answer) {
							System.out.printf("%d 맞췄습니다.\n", choose);
							System.out.printf("정답 : %d\n", answer);
							balance += betmoney * 2;
						} else {
							System.out.printf("%d 틀렸습니다.\n", choose);
							System.out.printf("정답 : %d\n", answer);
						}
					}
					break;
				}

				break;

			case 2:
				System.out.println("1. 이 게임은 홀/짝 게임입니다.");
				System.out.println("2. 베팅에 필요한 금액을 확인하세요.");
				System.out.println("3. 홀/짝을 선택 후 배팅 금액을 입력하세요.");
				System.out.println("4. 홀/짝을 맞추면 배팅금액을 2배로 돌려받고, 못맞추면 배팅금액을 잃습니다.");
				System.out.println("5. 즐거운 게임 되세요.");
				break;

			case 3:
				while (true) {
					System.out.println("============내 지갑============");
					System.out.println("1. 입금");
					System.out.println("2. 출금");
					System.out.println("3. 통장 잔고 확인");
					System.out.println("4. 뒤로 가기");
					System.out.print("선택 :");
					int menu2 = scan.nextInt();

					switch (menu2) {
					case 1:
						System.out.print("입금할 금액 :");
						inmoney = scan.nextInt();
						balance += inmoney;
						break;

					case 2:
						System.out.print("출금할 금액 :");
						outmoney = scan.nextInt();
						balance -= outmoney;
						if (balance < 0) {
							System.out.println("잔액이 부족합니다.");
							balance += outmoney;
						}
						break;

					case 3:
						System.out.printf("통장 잔고 확인 : %d\n", balance);
						break;

					case 4:
						close2 = 1;
						break;

					default:
						System.out.println("1~4 숫자를 입력하세요.");
						break;
					}

					if (close2 == 1) {
						close2 = 0;
						break;						
					}
				}

				break;
				
			case 4:
				close1 = 1;
				break;

			default:
				System.out.println("1~4 숫자를 입력하세요.");
				break;
			}
			if (close1 == 1)
				break;
		}

		System.out.println("종료되었습니다.");

	}

}
