package com.newlecture.homwork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Program32 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int studentCount = 30;
		int index = 1;
		int[] seats = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30 };
		String[] nameSeats = new String[studentCount];
		int[] randomValue = new int[studentCount];
		String[] students = new String[studentCount];

		EXIT: while (true) {
			int menu = inputMenu();

			switch (menu) {
			default:
				System.out.println("1 ~ 6 를 입력하세요");
				break;
			case 1:
				while (true) {
					System.out.println("학생 입력");
					System.out.print("학생 수를 입력하세요 (최대 30명) : ");
					studentCount = scan.nextInt();
					if (studentCount <= 30) {
						students = new String[30];
						nameSeats = new String[30];
						break;
					}
				}

				for (int i = 0; i < studentCount; i++) {
					System.out.printf("%d번째 학생 이름을 입력하세요 :", i + 1);
					students[i] = scan.next();

				}

				System.out.println("'2. 자리 배치'를 선택 후 이용하세요");

				break;
			case 2:
				// 랜덤 값 배열 생성 (중복 없이)
				for (int i = 0; i < 30; i++) {
					randomValue[i] = random.nextInt(30) + 1;
					for (int j = 0; j < i; j++)
						if (randomValue[i] == randomValue[j]) {
							i--;
						}
				}

				// 랜덤 값 배열과 고정석 배열이 같다면 이름좌석에 학생이름 대입
				for (int i = 0; i < 30; i++) {
					for (int j = 0; j < 30; j++) {
						if (randomValue[i] == seats[j]) {
							nameSeats[i] = students[j];
						}
					}
				}

				System.out.println("자리 배치 완료");

				break;
			case 3:
				printSeat(nameSeats);

				break;
			case 4:
				FileOutputStream fos = new FileOutputStream("res/seat.txt");
				PrintStream ps = new PrintStream(fos);

				for (int i = 0; i < 30; i++) {
					ps.print(" ");
					if (nameSeats[i] == null)
						ps.print("ㅡㅡㅡ ");
					else
						ps.printf("%s ", nameSeats[i]);

					if (i % 6 == 2)
						ps.print("\t\t");
					else if (i % 6 == 5)
						ps.println();
				}
				ps.println();

				for (int j = 0; j < 5; j++) {
					ps.printf("%d조 : ", j + 1);
					for (int i = 0 + (j * 6); i < 6 + (j * 6); i++) {
						ps.print(" ");
						if (nameSeats[i] == null)
							ps.print("ㅡㅡㅡ ");
						else
							ps.printf("%s ", nameSeats[i]);
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

				int a = 0;
				students = new String[30];
				while (fscan.hasNextLine() == true) {
					String nameSeatScan = fscan.nextLine();
					students[a] = nameSeatScan;
					a++;

				}
				studentCount = students.length;

				fscan.close();
				fis.close();
				System.out.println("파일 읽기 완료");
				System.out.println("'2. 자리 배치'를 선택 후 이용하세요");

				break;
			case 6:
				System.out.println("프로그램이 종료되었습니다.");
				break EXIT;
			}

		}

	}

	static void printSeat(String[] nameSeats) {
		System.out.println("학생 출력");
		System.out.print("=======================================================\n");
		System.out.print("                       4강의실 자리표                     \n");
		System.out.print("=======================================================\n");

		for (int i = 0; i < nameSeats.length; i++) {
			System.out.print("│ ");
			if (nameSeats[i] == null)
				System.out.print("ㅡㅡㅡ ");
			else
				System.out.printf("%s ", nameSeats[i]);

			if (i % 6 == 2)
				System.out.print("│\t\t");
			else if (i % 6 == 5)
				System.out.print("│\n");

		}
		System.out.println();

		for (int j = 0; j < 5; j++) {
			System.out.printf("%d조 : ", j + 1);
			for (int i = 0 + (j * 6); i < 6 + (j * 6); i++) {
				if (nameSeats[i] == null)
					System.out.print("");
				else
					System.out.printf("%s ", nameSeats[i]);
			}
			System.out.println();
		}
	}

	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
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
		return menu;

	}

}
