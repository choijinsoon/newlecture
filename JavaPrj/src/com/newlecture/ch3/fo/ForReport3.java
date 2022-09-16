package com.newlecture.ch3.fo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ForReport3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 성적 출력
		int kor1 = 0, kor2 = 0, kor3 = 0;
		int total;
		float avg;

		Scanner scan = new Scanner(System.in);

		EXIT: 
			while (true) {
			// ====================메인 메뉴====================
			System.out.print("┌────────────────────────────┐\n");
			System.out.print("│           메인 메뉴          │\n");
			System.out.print("└────────────────────────────┘\n");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 읽기");
			System.out.println("4. 성적 저장");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 > ");
			int menu = scan.nextInt();

			switch (menu) {
			case 1:
				// ====================성적 입력====================
				System.out.print("┌────────────────────────────┐\n");
				System.out.print("│           성적 입력          │\n");
				System.out.print("└────────────────────────────┘\n");

				do {
					System.out.print("국어1:");
					kor1 = scan.nextInt();
					if (kor1 < 0 || 100 < kor1)
						System.out.println("성적의 범위(0~100)를 벗어났습니다.");
				} while (kor1 < 0 || 100 < kor1);

				do {
					System.out.print("국어2:");
					kor2 = scan.nextInt();
					if (kor2 < 0 || 100 < kor2)
						System.out.println("성적의 범위(0~100)를 벗어났습니다.");
				} while (kor2 < 0 || 100 < kor2);

				do {
					System.out.print("국어3:");
					kor3 = scan.nextInt();
					if (kor3 < 0 || 100 < kor3)
						System.out.println("성적의 범위(0~100)를 벗어났습니다.");
				} while (kor3 < 0 || 100 < kor3);
				break;

			case 2:
				// ====================성적 출력====================
				total = kor1 + kor2 + kor3;
				avg = total / 3.0f;
				System.out.print("┌────────────────────────────┐\n");
				System.out.print("│           성적 출력          │\n");
				System.out.print("└────────────────────────────┘\n");
				System.out.printf("국어1:%d\n", kor1);
				System.out.printf("국어2:%d\n", kor2);
				System.out.printf("국어3:%d\n", kor3);
				System.out.printf("총점:%d\n", total);
				System.out.printf("평균:%f\n", avg);
				break;

			case 3:
				// ====================성적 읽기====================
				FileInputStream fis = new FileInputStream("res/data.txt");
				Scanner fscan = new Scanner(fis);
				
				fscan.nextLine();
				kor1 = Integer.parseInt(fscan.nextLine());
				kor2 = Integer.parseInt(fscan.nextLine());
				kor3 = Integer.parseInt(fscan.nextLine());
				
				System.out.println("파일 읽기 완료");
				
				fscan.close();
				fis.close();
				break;

			case 4:
				// ====================성적 저장====================
				FileOutputStream fout = new FileOutputStream("res/data.txt");
				PrintStream ps = new PrintStream(fout);
				
				ps.println("kor");
				ps.println(kor1);
				ps.println(kor2);
				ps.println(kor3);
				
				System.out.println("성적 저장 완료");
				
				ps.close();
				fout.close();
				break;

			case 5:
				System.out.println("종료");
				break EXIT;

			default:
				System.out.println("1 ~ 5");
				break;
			}
		}
	}
}
