package com.newlecture.homework_report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Report3 {

	public static void main(String[] args) throws IOException {
		int[][] kors = new int[3][3];
		int[] total = new int[3];
		float[] avg = new float[3];

		Scanner scan = new Scanner(System.in);

		EXIT: while (true) {
			System.out.println("┌────────────────────┐");
			System.out.println("│       성적 관리      │");
			System.out.println("└────────────────────┘");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 읽기");
			System.out.println("4. 성적 저장");
			System.out.println("5. 종료");
			System.out.print("선택 > ");
			int menu = scan.nextInt();

			switch (menu) {
			default:
				System.out.println("1 ~ 5 를 입력하세요");
				break;
			case 1:
				System.out.println("성적 입력");
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						do {
							System.out.printf("%d학년 국어%d :", i + 1, j + 1);
							kors[i][j] = scan.nextInt();
							if (kors[i][j] < 0 || 100 < kors[i][j])
								System.out.println("성적을 다시 입력하세요");
						} while (kors[i][j] < 0 || 100 < kors[i][j]);
					}
				}
				System.out.println("성적 입력 완료");
				break;

			case 2:
				System.out.println("성적 출력");
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.printf("%d학년 국어%d : %d\n", j + 1, i + 1, kors[i][j]);
						total[i] += kors[i][j];
						avg[i] = total[i] / 3.0F;
					}
					System.out.printf("%d학년 총합 : %d\n", i + 1, total[i]);
					System.out.printf("%d학년 평균 : %4.2f\n", i + 1, avg[i]);
					System.out.println("============================");
				}

				System.out.println("성적 출력 완료");
				break;
			case 3:
				System.out.println("성적 읽기");
				FileInputStream fis = new FileInputStream("res/data.txt");
				Scanner fscan = new Scanner(fis);

				fscan.nextLine();
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						kors[i][j] = fscan.nextInt();

				fis.close();
				fscan.close();

				System.out.println("성적 읽기 완료");
				break;
			case 4:
				System.out.println("성적 저장");
				FileOutputStream fos = new FileOutputStream("res/data.txt");
				PrintStream ps = new PrintStream(fos);

				ps.println("kor");
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						ps.println(kors[i][j]);

				fos.close();
				ps.close();

				System.out.println("성적 저장 완료");
				break;
			case 5:
				System.out.println("프로그램 종료");
				break EXIT;
			}
		}
	}

}
