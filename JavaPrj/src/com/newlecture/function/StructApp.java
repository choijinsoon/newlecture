package com.newlecture.function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class StructApp {
//	int[] i = new int[3]; // main 함수 안의 Exam exam = new Exam(); 
//	
//	int[] k = {1,2,3}; // 함수 안에서 생성한 Exam exam 의 kor,eng,math 값
//	
//	i=k; // main 함수 안의 exam 은 함수 안에서 생성한 exam 의 값을 참조하는 변수이다
	public static void main(String[] args) throws IOException {
		

		Scanner scan = new Scanner(System.in);

		Exam exam = new Exam();

		EXIT: while (true) {

			int menu = inputMenu();

			switch (menu) {
			case 1:
				inputExam(exam);
				break;
			case 2:
				printExam(exam);
				break;
			case 3:
				saveExam(exam);
				break;
			case 4:
				readExam(exam);
				break;
			case 5:
				System.out.println("Bye~~~");
				break EXIT;

			default:
				System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
				break;
			}
		}
	}

	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            메인 메뉴           │\n");
		System.out.print("└─────────────────────────────┘\n");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 성적저장");
		System.out.println("4. 성적읽기");
		System.out.println("5. 종료");
		System.out.print(">");
		int menu = scan.nextInt();
		return menu;
	}
	


	static void inputExam(Exam exam) {
		Scanner scan = new Scanner(System.in);
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            메인 입력          │\n");
		System.out.print("└─────────────────────────────┘\n");

		String[] titles = { "kor", "eng", "math" };
		int[] nums = new int[3];

		for (int i = 0; i < 3; i++) {
			int temp;
			do {
				System.out.printf("%s:", titles[i]);
				temp = scan.nextInt();

				if (temp < 0 || temp > 100)
					System.out.println("성적은 (0~100) 범위를 벗어날 수 없습니다.");

			} while (temp < 0 || temp > 100);

			nums[i] = temp;
		}

		exam.kor = nums[0];
		exam.eng = nums[1];
		exam.math = nums[2];

	}

	static void printExam(Exam exam) {
		int total = exam.kor + exam.eng + exam.math;
		float avg = total / 3.0f;

		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            성적 출력           │\n");
		System.out.print("└─────────────────────────────┘\n");

		System.out.printf("kor : %d\n", exam.kor);
		System.out.printf("eng : %d\n", exam.eng);
		System.out.printf("math : %d\n", exam.math);
		System.out.printf("total : %d\n", total);
		System.out.printf("avg : %f\n", avg);
	}

	static void readExam(Exam exam) throws IOException {
		FileInputStream fis = new FileInputStream("res/data.csv");
		Scanner fscan = new Scanner(fis);

		String titles = fscan.nextLine(); // 필드명 행 건너뛰기
		String[] nums = fscan.nextLine().split(",");
		exam.kor = Integer.parseInt(nums[0]);
		exam.eng = Integer.parseInt(nums[1]);
		exam.math = Integer.parseInt(nums[2]);

		fscan.close();
		fis.close();

	}

	static void saveExam(Exam exam) throws IOException {
		FileOutputStream fos = new FileOutputStream("res/data.csv");
		PrintStream fout = new PrintStream(fos);

		fout.println("kor,eng,math");
		fout.printf("%d,%d,%d\n", exam.kor, exam.eng, exam.math);

		fout.close();
		fos.close();
	}
}
