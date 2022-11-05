package com.newlecture.ch5.array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 성적 출력
//		int kor1 = 0, kor2 = 0, kor3 = 0;
		int[] kors = new int[3];
		int[] engs = new int[3];
		int[] maths = new int[3];

		Scanner scan = new Scanner(System.in);

		EXIT: while (true) {
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

				for (int i = 0; i < 3; i++) {
					do {
						System.out.printf("국어%d:", i + 1);
						kors[i] = scan.nextInt();
						if (kors[i] < 0 || 100 < kors[i] )
							System.out.println("성적의 범위(0~100)를 벗어났습니다.");
					} while (kors[i] < 0 || 100 < kors[i]);
					
					do {
						System.out.printf("영어%d:", i + 1);
						engs[i] = scan.nextInt();
						if (engs[i] < 0 || 100 < engs[i] )
							System.out.println("성적의 범위(0~100)를 벗어났습니다.");
					} while (engs[i] < 0 || 100 < engs[i]);
					
					do {
						System.out.printf("수학%d:", i + 1);
						maths[i] = scan.nextInt();
						if (maths[i] < 0 || 100 < maths[i] )
							System.out.println("성적의 범위(0~100)를 벗어났습니다.");						
					} while (maths[i] < 0 || 100 < maths[i]);
				}
				break;
			case 2:
				// ====================성적 출력====================
				System.out.print("┌────────────────────────────┐\n");
				System.out.print("│           성적 출력          │\n");
				System.out.print("└────────────────────────────┘\n");

				System.out.printf("%10s%10s%10s%10s%10s\n", "국어", "영어", "수학", "총점", "평균");

				for (int i = 0; i < 3; i++) {
					int total = kors[i] + engs[i] + maths[i];
					float avg = total / 3.0f;
					
					System.out.printf("%d%10d%10d%10d%10d%10.2f",i+1, kors[i], engs[i], maths[i], total, avg);
					System.out.println();
				}
				break;

			case 3:
				// ====================성적 읽기====================
				FileInputStream fis = new FileInputStream("res/data2.csv");
				Scanner fscan = new Scanner(fis);

				fscan.nextLine();

				for (int i = 0; i < 3; i++) {
					String[] tokens = fscan.nextLine().split(",");

					int kor = Integer.parseInt(tokens[0]);
					int eng = Integer.parseInt(tokens[1]);
					int math = Integer.parseInt(tokens[2]);

					kors[i] = kor;
					engs[i] = eng;
					maths[i] = math;

					System.out.println(kors[i]);
					System.out.println(engs[i]);
					System.out.println(maths[i]);

				}

//				for (int i = 0; i < 3; i++)
//					kors[i] = Integer.parseInt(fscan.nextLine());

				fscan.close();
				fis.close();
				System.out.println("파일 읽기 완료");
				break;

			case 4:
				// ====================성적 저장====================
				FileOutputStream fout = new FileOutputStream("res/data2.csv");
				PrintStream ps = new PrintStream(fout);

				ps.println("kor,eng,math");
				for (int i = 0; i < 3; i++) {
					ps.printf("%d,", kors[i]);
					ps.printf("%d,", engs[i]);
					ps.printf("%d", maths[i]);
					ps.println();
				}

				ps.close();
				fout.close();
				System.out.println("성적 저장 완료");
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
