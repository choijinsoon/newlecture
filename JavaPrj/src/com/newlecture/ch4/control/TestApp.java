package com.newlecture.ch4.control;

import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {
		// 123456으로 초기화된 정수열 배열
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int num;

		Scanner scan = new Scanner(System.in);

		for (int j = 0; j< 5; j++) {
			for (int i = 0; i < 5; i++) {
				num = nums[1 + 2 * i];
				System.out.printf("%d ", num);
			}
			System.out.println();
		}

//		System.out.println(scan.nextLine());

//		for (int i = 0; i < nums.length; i++)
//			System.out.println(nums[i]);

	}

}
