package com.newlecture.part3.ch3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] nums;

	public Lotto() {
		nums = new int[6];
	}

	public int get(int n) {
		return nums[n];
	}

	public void sort() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	public void set(int n, int value) {
		this.nums[n] = value;
	}

}
