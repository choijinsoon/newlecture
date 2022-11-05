package com.newlecture.homework_report;

public class Report4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		12345
//		23456
//		34567
//		45678
//		56789

		int[] nums = new int[5];

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				nums[i] = i + j + 1;
				System.out.printf("%d", nums[i]);
			}
			System.out.println();
		}
	}

}
