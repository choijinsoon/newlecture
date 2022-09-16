package com.newlecture.homwork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int studentCount = 6;
		int index = 1;
		int[] seats = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30 };
		String[] nameSeats = new String[studentCount];
		int[] randomValue = new int[studentCount];
		String[] students = new String[studentCount];

		EXIT: while (true) {
			System.out.println("┌────────────────────────────────┐");
			System.out.println("│             메인 메뉴            │");
			System.out.println("└────────────────────────────────┘");
			System.out.println("1. 학생 입력");
			System.out.println("2. 자리 배치");
			System.out.println("3. 학생 출력");
			System.out.println("4. 파일 저장");
			System.out.println("5. 파일 읽기");
			System.out.println("6. 종료");
			System.out.print("선택 > ");
			int menu = scan.nextInt();

			switch (menu) {
			default:
				System.out.println("1 ~ 6 를 입력하세요");
				break;
			case 1:
				while (true) {
					System.out.println("학생 입력");
					System.out.print("학생 수를 입력하세요 (최대 30명) : ");
					studentCount = scan.nextInt();
					if (studentCount <= 30)
						break;
				}
				students = new String[studentCount];
				nameSeats = new String[studentCount];
				randomValue = new int[studentCount];

				// 배열 늘리기
				for (int i = 0; i < studentCount; i++) {
					index++;
					if (index >= studentCount) {
						String[] tmpStudentCount = new String[studentCount];
						for (int j = 0; j < studentCount - 1; j++)
							tmpStudentCount[j] = students[j];
						students = tmpStudentCount;
					}
					System.out.println("학생 이름을 입력하세요 :");
					students[i] = scan.next();

				}

				break;
			case 2:
				// 랜덤 값 배열 생성 (중복 없이)
				for (int i = 0; i < studentCount; i++) {
					randomValue[i] = random.nextInt(studentCount) + 1;
					for (int j = 0; j < i; j++)
						if (randomValue[i] == randomValue[j]) {
							i--;
						}
				}

				// 랜덤 값 배열과 고정석 배열이 같다면 이름좌석에 학생이름 대입
				for (int i = 0; i < studentCount; i++) {
					for (int j = 0; j < studentCount; j++) {
						if (randomValue[i] == seats[j]) {
							nameSeats[i] = students[j];
						}
					}
				}
				System.out.println("자리 배치 완료");

				break;
			case 3:
				System.out.println("학생 출력");
				System.out.print("============================================\n");
				System.out.print("                 4강의실 자리표                \n");
				System.out.print("============================================\n");

				for (int i = 0; i < nameSeats.length; i++) {
					if ((i + 1) % 6 == 1) {
						System.out.print("│");

					}
					System.out.printf("%4s", nameSeats[i]);

					if ((i + 1) % 6 == 3) {
						System.out.print(" │");
						System.out.print("\t");
						System.out.print("│");
					} else if ((i + 1) % 6 == 0) {
						System.out.print(" │");
						System.out.println();
					}

				}
				System.out.println();

				// 조 편성
				if (studentCount <= 6) {
					System.out.print("1조 : ");
					for (int i = 0; i < studentCount; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();
				} else if (6 < studentCount && studentCount <= 12) {
					System.out.print("1조 : ");
					for (int i = 0; i < 6; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("2조 : ");
					for (int i = 6; i < studentCount; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();
				} else if (12 < studentCount && studentCount <= 18) {
					System.out.print("1조 : ");
					for (int i = 0; i < 6; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("2조 : ");
					for (int i = 6; i < 12; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("3조 : ");
					for (int i = 12; i < studentCount; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();
				} else if (18 < studentCount && studentCount <= 24) {
					System.out.print("1조 : ");
					for (int i = 0; i < 6; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("2조 : ");
					for (int i = 6; i < 12; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("3조 : ");
					for (int i = 12; i < 18; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("4조 : ");
					for (int i = 18; i < studentCount; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();
				} else if (24 < studentCount && studentCount <= 30) {
					System.out.print("1조 : ");
					for (int i = 0; i < 6; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("2조 : ");
					for (int i = 6; i < 12; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("3조 : ");
					for (int i = 12; i < 18; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("4조 : ");
					for (int i = 18; i < 24; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();

					System.out.print("5조 : ");
					for (int i = 24; i < studentCount; i++) {
						System.out.printf("%s ", nameSeats[i]);
					}
					System.out.println();
				}

				break;
			case 4:
				FileOutputStream fos = new FileOutputStream("res/seat.txt");
				PrintStream ps = new PrintStream(fos);

				for (int i = 0; i < studentCount; i++) {
					ps.print(",");
					ps.print(nameSeats[i]);
					if (i % 6 == 5)
						ps.println();
				}
				ps.println();

				if (studentCount <= 6) {
					ps.print("1조 :");
					for (int i = 0; i < studentCount; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();
				} else if (6 < studentCount && studentCount <= 12) {
					ps.print("1조 :");
					for (int i = 0; i < 6; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("2조 :");
					for (int i = 6; i < studentCount; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();
				} else if (12 < studentCount && studentCount <= 18) {
					ps.print("1조 :");
					for (int i = 0; i < 6; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("2조 :");
					for (int i = 6; i < 12; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("3조 :");
					for (int i = 12; i < studentCount; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();
				} else if (18 < studentCount && studentCount <= 24) {
					ps.print("1조 :");
					for (int i = 0; i < 6; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("2조 :");
					for (int i = 6; i < 12; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("3조 :");
					for (int i = 12; i < 18; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("4조 :");
					for (int i = 18; i < studentCount; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();
				} else if (24 < studentCount && studentCount <= 30) {
					ps.print("1조 :");
					for (int i = 0; i < 6; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("2조 :");
					for (int i = 6; i < 12; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("3조 :");
					for (int i = 12; i < 18; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("4조 :");
					for (int i = 18; i < 24; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();

					ps.print("5조 :");
					for (int i = 24; i < studentCount; i++) {
						ps.print(" ");
						ps.print(nameSeats[i]);
					}
					ps.println();
				}

				ps.close();
				fos.close();
				System.out.println("파일 저장 완료");

				break;
			case 5:

				FileInputStream fis = new FileInputStream("res/seat2.txt");
				Scanner fscan = new Scanner(fis);

				while (fscan.hasNextLine() == true) {
					for (int i = 0; i < 6; i++) {
						String nameSeatScan = fscan.nextLine();
						if(nameSeats.length>=nameSeatScan.length()) {
							String[] tmp_nameSeats = new String[nameSeats.length+1];
							
						}
						nameSeats[i] = nameSeatScan;
					}
				}

//				for (int i = 0; i < studentCount; i++) {
//					index++;
//					if (index >= studentCount) {
//						String[] tmpStudentCount = new String[studentCount];
//						for (int j = 0; j < studentCount - 1; j++)
//							tmpStudentCount[j] = students[j];
//						students = tmpStudentCount;
//					}
//					System.out.println("학생 이름을 입력하세요 :");
//					students[i] = scan.next();
//
//				}

				fscan.close();
				fis.close();
				System.out.println("성적 읽기 완료");

				break;
			case 6:
				System.out.println("프로그램이 종료되었습니다.");
				break EXIT;
			}

		}

	}

}
