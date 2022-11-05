package com.newlecture.part3.ch2;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] nums;

	public void input() {
		System.out.println("로또 입력");
		nums = new int[6];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			do {
				System.out.printf("%d번째 번호 :", i + 1);
				nums[i] = scan.nextInt();
				if (nums[i] <= 0 || 46 <= nums[i])
					System.out.println("1 ~ 45 다시 입력하세요");
				else {
					for (int j = 0; j < i; j++) {
						if (nums[i] == nums[j]) {
							System.out.println("중복입니다. 다시 입력하세요");
							i--;
						}

					}
				}
			} while (nums[i] <= 0 || 46 <= nums[i]);
		}
		System.out.println("===========================");
	}

	public void print() {
		System.out.println("로또 출력");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d번째 번호 :", i + 1);
			System.out.println(nums[i]);
		}
		System.out.println("===========================");
	}

	public void sort() {
		System.out.println("로또 정렬");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		System.out.println("===========================");
	}

}
