package com.newlecture.ch5.array;

import java.io.IOException;
import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int max = 3;
		int[] kors = new int[max];
		int[] engs = new int[max];
		int[] maths = new int[max];
		int index = 0;

		Scanner scan = new Scanner(System.in);

		// 성적 입력

		System.out.print("┌────────────────────────────┐\n");
		System.out.print("│           성적 입력          │\n");
		System.out.print("└────────────────────────────┘\n");

		int go = 0;
		do {
			// 국어성적 입력
			int kor;
			int eng;
			int math;

			do {
				System.out.print("국어성적을 입력하세요 : ");
				kor = scan.nextInt();
				if (kor < 0 || 100 < kor)
					System.out.println("성적의 범위(0~100)를 벗어났습니다.");
			} while (kor < 0 || 100 < kor);

			if (index >= max) {
				int[] temp = new int[max];

				for (int i = 0; i < max; i++)
					temp[i] = kors[i];

				kors = temp;
				max += 1;
			}

			kors[index] = kor;
			index++;

			// 영어성적 입력
//			do {
//				System.out.print("영어성적을 입력하세요 : ");
//				eng = scan.nextInt();
//				if (eng < 0 || 100 < eng)
//					System.out.println("성적의 범위(0~100)를 벗어났습니다.");
//			} while (eng < 0 || 100 < eng);
//
//			if (index >= max) {
//				int[] temp = new int[++max];
//				
//				for (int i = 0; i < max; i++)
//					temp[i] = engs[i];
//				
//				engs = temp;
//			}
			// 수학성적 입력
//			do {
//				System.out.print("수학성적을 입력하세요 : ");
//				math = scan.nextInt();
//				if (math < 0 || 100 < math)
//					System.out.println("성적의 범위(0~100)를 벗어났습니다.");
//			} while (math < 0 || 100 < math);
//
//			if (index >= max) {
//				int[] temp = new int[++max];
//				
//				for (int i = 0; i < max; i++)
//					temp[i] = maths[i];
//				
//				maths = temp;
//			}

			// 3개가 넘어가면 메모리 비효율
			// 크기 6개이상 불가
			// 공간늘리기 반복

//			kors[index] = kor;
//			engs[index] = eng;
//			maths[index] = math;
//			index++;

			// 진행상황 문의
			System.out.println("계속 입력하겠습니까? (1.예 2.아니오)");
			System.out.print("> ");
			go = scan.nextInt();

		} while (go == 1);

		// 원하는 수만큼 출력

	}
}
