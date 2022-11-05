package com.newlecture.homework_report;

public class Report1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		문제1
//		배열 : 1 2 3 4 5 6 7 8 9 10
//		합 : 55

		int[] nums1 = new int[10];
		int total = 0;

		System.out.print("배열 : ");

		for (int i = 0; i < 10; i++) {
			nums1[i] = i + 1;
			System.out.printf("%d ", nums1[i]);
			total += nums1[i];
		}

		System.out.println();
		System.out.printf("합 : %d\n", total);

		System.out.println("=========================================");
//		문제2
//		-----2단------
//		2 X 1 = 2
//		2 X 2 = 4
//		2 X 3 = 6
//		2 X 4 = 8
//		2 X 5 = 10
//		2 X 6 = 12
//		2 X 7 = 14
//		2 X 8 = 16
//		2 X 9 = 18
//		...

		for (int j = 0; j < 8; j++) {
			System.out.printf("-----%d단-----\n", j + 2);
			for (int i = 0; i < 9; i++)
				System.out.printf("%d X %d = %d\n", j + 2, i + 1, (j + 2) * (i + 1));
		}

		System.out.println("=========================================");
//		문제3
//		 기존
//		 4 1 3 10 5 7 6 2 9 8
//		 정렬 후
//		 8 9 2 6 7 5 10 3 1 4

		int[] nums3 = { 4, 1, 3, 10, 5, 7, 6, 2, 9, 8 };

		for (int i = 0; i < 5; i++) {
			int temp = nums3[i];
			nums3[i] = nums3[9 - i];
			nums3[9 - i] = temp;
		}

		for (int i = 0; i < 10; i++)
			System.out.printf("%d ", nums3[i]);

		System.out.println();

		System.out.println("=========================================");
//		문제4
//		12345
//		23456
//		34567
//		45678
//		56789

		int[] nums4 = new int[5];

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				nums4[i] = i + j + 1;
				System.out.printf("%d", nums4[i]);
			}
			System.out.println();
		}

	}

}
