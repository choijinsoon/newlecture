package com.newlecture.homwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.print.PrintService;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		## < 성적 관리 프로그램 >
//
//		- 국영수 국영수 점수 입력
//		- 국영수 점수 출력
//		- 국영수 국영수 점수 읽기
//		- 국영수 점수 저장
//
//		1. **[Program.java](http://Program.java) 파일로 통일**
//		2. **성적 입력**
//		3. **성적 출력**
//		4. **성적 읽기**
//		5. **성적 저장**
//
//		## < 시험 제출 >
//
//		- **1시 20분까지 (점심시간 전)**
//		- **newjyh213@gmail.com**

		int arraySize = 1;
		int[] kor = new int[arraySize];
		int[] eng = new int[arraySize];
		int[] math = new int[arraySize];
		int[] total = new int[arraySize];
		float[] avg = new float[arraySize];

		Scanner scan = new Scanner(System.in);

		EXIT_MENU: while (true) {
			System.out.println("┌────────────────────────────────┐");
			System.out.println("│             메인 메뉴            │");
			System.out.println("└────────────────────────────────┘");
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

				arraySize = 1;
				System.out.println("성적 입력");

				EXIT_INPUT: for (int i = 0; i < arraySize; i++) {

					do {
						System.out.printf("국어%d 점수 :", i + 1);
						kor[i] = scan.nextInt();
						if (kor[i] < 0 || 100 < kor[i])
							System.out.println("점수를 다시 입력하세요 ( 0 ~ 100 )");
						else
							break;
					} while (kor[i] < 0 || 100 < kor[i]);
					do {
						System.out.printf("영어%d 점수 :", i + 1);
						eng[i] = scan.nextInt();
						if (eng[i] < 0 || 100 < eng[i])
							System.out.println("점수를 다시 입력하세요 ( 0 ~ 100 )");
						else
							break;
					} while (eng[i] < 0 || 100 < eng[i]);
					do {
						System.out.printf("수학%d 점수 :", i + 1);
						math[i] = scan.nextInt();
						if (math[i] < 0 || 100 < math[i])
							System.out.println("점수를 다시 입력하세요 ( 0 ~ 100 )");
						else
							break;
					} while (math[i] < 0 || 100 < math[i]);

					while (true) {
						System.out.println("계속 하시겠습니까? (1.예 2.아니오)");
						int continueMenu = scan.nextInt();
						if (continueMenu == 1) {
							arraySize++;
							int[] tmp_kor = new int[arraySize];
							int[] tmp_eng = new int[arraySize];
							int[] tmp_math = new int[arraySize];
							total = new int[arraySize];
							avg = new float[arraySize];
							for (int j = 0; j < arraySize - 1; j++) {
								tmp_kor[j] = kor[j];
								tmp_eng[j] = eng[j];
								tmp_math[j] = math[j];
							}
							kor = tmp_kor;
							eng = tmp_eng;
							math = tmp_math;
							break;
						} else if (continueMenu == 2) {
							System.out.println("종료되었습니다.");
							break EXIT_INPUT;
						} else
							System.out.println("다시 입력하세요 ( 1 or 2 )");
					}
					
				}

				break;
			case 2:
				System.out.println("성적 출력");

				for (int i = 0; i < arraySize; i++) {
					total[i] = kor[i] + eng[i] + math[i];
					avg[i] = total[i] / 3.0F;

					System.out.printf("국어%d 점수 : %d\n", i + 1, kor[i]);
					System.out.printf("영어%d 점수 : %d\n", i + 1, eng[i]);
					System.out.printf("수학%d 점수 : %d\n", i + 1, math[i]);
					System.out.printf("총점 : %d\n", total[i]);
					System.out.printf("평균 : %6.2f\n", avg[i]);
				}

				break;
			case 3:
				System.out.println("성적 읽기");

				int a = 0;
				
				FileInputStream fis = new FileInputStream("res/data.txt");
				Scanner fscan = new Scanner(fis);

				fscan.nextLine();

				while (fscan.hasNextLine() == true) {
					if(arraySize<=a) {
						arraySize++;
						int[] tmp_kor = new int[arraySize];
						int[] tmp_eng = new int[arraySize];
						int[] tmp_math = new int[arraySize];
						total = new int[arraySize];
						avg = new float[arraySize];
						for (int j = 0; j < arraySize - 1; j++) {
							tmp_kor[j] = kor[j];
							tmp_eng[j] = eng[j];
							tmp_math[j] = math[j];
						}
						kor = tmp_kor;
						eng = tmp_eng;
						math = tmp_math;
					}
					String[] kors = fscan.nextLine().split(",");
					kor[a] = Integer.parseInt(kors[0]);
					eng[a] = Integer.parseInt(kors[1]);
					math[a] = Integer.parseInt(kors[2]);
					a++;
				}

				fscan.close();
				fis.close();

				break;
			case 4:
				System.out.println("성적 저장");

				FileOutputStream fos = new FileOutputStream("res/data.txt");
				PrintStream ps = new PrintStream(fos);

				ps.println("kor,eng,math");
				for (int i = 0; i < arraySize; i++) {
					ps.print(kor[i]);
					ps.print(",");
					ps.print(eng[i]);
					ps.print(",");
					ps.print(math[i]);
					ps.println();
				}

				ps.close();
				fos.close();

				break;
			case 5:
				System.out.println("종료되었습니다.");
				break EXIT_MENU;
			}
		}

	}

}
