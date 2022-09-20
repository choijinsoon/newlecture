package com.newlecture.part3.ch2;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            성적 입력          │\n");
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

		kor = nums[0];
		eng = nums[1];
		math = nums[2];
	}


	public void print() {
		int total = kor + eng + math;
		float avg = total / 3.0f;

		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            성적 출력          │\n");
		System.out.print("└─────────────────────────────┘\n");

		System.out.printf("kor : %d\n", kor);
		System.out.printf("eng : %d\n", eng);
		System.out.printf("math : %d\n", math);
		System.out.printf("total : %d\n", total);
		System.out.printf("avg : %f\n", avg);
	}


	public void inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            메인 메뉴          │\n");
		System.out.print("└─────────────────────────────┘\n");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.print(">");
		int menu = scan.nextInt();
	}

}
