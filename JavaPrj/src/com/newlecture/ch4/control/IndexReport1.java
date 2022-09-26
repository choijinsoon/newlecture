package com.newlecture.ch4.control;
import java.util.Scanner;

public class IndexReport1 {

	public static void main(String[] args) {
		// 성적 출력
		int kor1, kor2, kor3;
		int total;
		float avg;

		Scanner scan = new Scanner(System.in);

		System.out.print("┌────────────────────────────┐\n");
		System.out.print("│           성적 입력          │\n");
		System.out.print("└────────────────────────────┘\n");
		System.out.print("국어1:");
		kor1 = scan.nextInt();
		System.out.print("국어2:");
		kor2 = scan.nextInt();
		System.out.print("국어3:");
		kor3 = scan.nextInt();

		total = kor1 + kor2 + kor3;
		avg = total / 3.0f;

		System.out.print("┌────────────────────────────┐\n");
		System.out.print("│           성적 출력          │\n");
		System.out.print("└────────────────────────────┘\n");

		for(int i=0; i<3; i++) {
			System.out.printf("--------------<%d>-------------\n", 3-i);
			System.out.printf("국어1:%d\n", kor1);
			System.out.printf("국어2:%d\n", kor2);
			System.out.printf("국어3:%d\n", kor3);
			System.out.printf("총점:%d\n", total);
			System.out.printf("평균:%f\n", avg);
			System.out.println();
		}

	}

}
