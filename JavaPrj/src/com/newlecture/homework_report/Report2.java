package com.newlecture.homework_report;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 너비와 높이는 변수로 선언해서 수정하기 편하게 해야함.
		final int WIDTH = 21;
		final int HEIGHT = 21;

		char[][] board = new char[HEIGHT][WIDTH];

		Scanner scan = new Scanner(System.in);

		int ox, oy;
		char dol = '●';
		EXIT: while (true) {

			for (int y = 1; y <= HEIGHT; y++)
				for (int x = 1; x <= WIDTH; x++) {
					board[y - 1][x - 1] = '┼';
					if (x == 1 && y == 1)
						board[y - 1][x - 1] = '┌';
					else if (x == WIDTH && y == 1)
						board[y - 1][x - 1] = '┐';
					else if (x == 1 && y == HEIGHT)
						board[y - 1][x - 1] = '└';
					else if (x == WIDTH && y == HEIGHT)
						board[y - 1][x - 1] = '┘';
					else if (y == 1)
						board[y - 1][x - 1] = '┬';
					else if (y == HEIGHT)
						board[y - 1][x - 1] = '┴';
					else if (x == 1)
						board[y - 1][x - 1] = '├';
					else if (x == WIDTH)
						board[y - 1][x - 1] = '┤';

				}

			System.out.print("┌────────────────────────────┐\n");
			System.out.print("│           오목 게임          │\n");
			System.out.print("└────────────────────────────┘\n");
			System.out.println("1. 게임 시작");
			System.out.println("2. 종료");
			System.out.print("선택 > ");
			int menu = scan.nextInt();

			switch (menu) {
			default:
				System.out.println("1 ~ 2");
				break;
			case 1:
				while(true) {
					System.out.printf("%c 오목 위치를 입력하세요 ( x, y 값 0 입력 시 뒤로 이동 )\n", dol);
					System.out.print("x y >");
					ox = Integer.parseInt(scan.next());
					oy = Integer.parseInt(scan.next());

					if (ox == 0 || oy == 0) {
						System.out.println("뒤로 이동");
						break;
					}

					else if (ox < 0 || WIDTH < ox || oy < 0 || HEIGHT < oy)
						System.out.println("범위를 벗어났습니다.\n다시 입력하세요");

					else if (board[oy - 1][ox - 1] == '○' || board[oy - 1][ox - 1] == '●')
						System.out.println("중복입니다.\n다시 입력하세요");

					else {
						board[oy - 1][ox - 1] = dol;
						if (dol == '○')
							dol = '●';
						else
							dol = '○';
					}

					for (int y = 1; y <= HEIGHT; y++) {
						for (int x = 1; x <= WIDTH; x++)
							System.out.printf("%c", board[y - 1][x - 1]);
						System.out.println();
					}

				} 

				break;

			case 2:
				System.out.println("프로그램 종료");
				break EXIT;

			}
		}

	}
}
