package com.newlecture.homwork;

import java.util.Random;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			nums[i] = rand.nextInt(7) + 1;
			for (int j = 0; j < i; j++) {
				while (nums[i] == nums[j])
					i--;
			}
		}
		for (int i = 0; i < 6; i++)
			System.out.println(nums[i]);
	}

}
