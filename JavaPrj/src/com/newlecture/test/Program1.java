package com.newlecture.test;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 5, 2, 7, 4, 6, 90, 3 };
		int total = 0;

		for (int i = 0; i < 7; i++) {
			total += nums[i];
			if (nums[i] == 90) {
				System.out.printf("total is %d", total);
				break;
			}
		}
	}

}
