package com.newlecture.test;

import java.util.Random;
import java.util.Scanner;

public class SeatRandomApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 3;
		int y = 4;
		int person =0;
		int[][] seats = new int[y][x];
		int[][] randomValues = new int[y][x];
		String[][] names = new String[y][x];
		String[] insertNames = new String[person];

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("=====좌석 배치 프로그램====");
			System.out.println("1. 인원 수 입력");
			System.out.println("2. 좌석 배치 실행");
			System.out.println("3. 좌석 확인");
			System.out.println("4. 좌석 이동");
			System.out.println("5. 종료");
			System.out.print("선택 > ");
			int menu = scan.nextInt();

			switch (menu) {
			default:
				System.out.println("다시 입력하세요");
				break;
			case 1:
				System.out.print("인원 수 입력 :");
				person = scan.nextInt();
				insertNames = new String[person];
				if (person > x * y)
					System.out.println("인원 수 초과입니다.");

				else {
					System.out.printf("이름 입력:");
					for (int i = 0; i < person; i++)
						insertNames[i] = scan.next();
				}
				for (int i = 0; i < person; i++)
					System.out.printf("%s ", insertNames[i]);

				break;
			case 2:
				System.out.println("좌석 배치 실행");
				Random random = new Random();
				for (int j = 0; j < y; j++)
					for (int i = 0; i < x; i++) {
						seats[j][i] = random.nextInt(x * y) + 45;
					}

				break;
			case 3:
				System.out.println("좌석 확인");

				for (int i = 0; i < x; i++) {
					names[0][i] = insertNames[i];
					for (int j = 1; j < x * j; j++)
						if (person > x * j)
							names[j][i] = insertNames[i + person];
				}

				for (int j = 0; j < y; j++) {
					for (int i = 0; i < x; i++)
						System.out.printf("%s ", names[j][i]);
					System.out.println();
				}
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}

	}

}
