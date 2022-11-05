package com.newlecture.function;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LottoApp {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		Lotto answer = new Lotto();

		lotto.nums = new int[6];
		answer.nums = new int[6];

		inputLotto(lotto);
		createLotto(answer);
		printLotto(lotto, "입력");
		printLotto(answer, "정답");
	}

	static void inputLotto(Lotto lotto) {

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			do {
				System.out.printf("%d번째 번호를 입력하세요 :", i + 1);
				lotto.nums[i] = scan.nextInt();
				if (lotto.nums[i] <= 0 || 46 <= lotto.nums[i])
					System.out.println("1 ~ 45 다시 입력하세요");
				else {
					for (int j = 0; j < i; j++) {
						if (lotto.nums[i] == lotto.nums[j]) {
							System.out.println("중복입니다. 다시 입력하세요");
							i--;
						}

					}
				}
			} while (lotto.nums[i] <= 0 || 46 <= lotto.nums[i]);
		}
	}

	static void createLotto(Lotto answer) {
		Random rd = new Random();
		for (int i = 0; i < 6; i++) {
			answer.nums[i] = rd.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (answer.nums[i] == answer.nums[j]) {
					i--;
				}
			}
		}
	}

	static void printLotto(Lotto lotto, String s) {
		System.out.printf("%s : ", s);
		for (int i = 0; i < lotto.nums.length; i++) {
			for (int j = 0; j < lotto.nums.length; j++) {
				if (lotto.nums[i] > lotto.nums[j]) {
					int temp = lotto.nums[i];
					lotto.nums[i] = lotto.nums[j];
					lotto.nums[j] = temp;
				}
			}
			System.out.printf("%d ", lotto.nums[i]);
		}
		System.out.println();
	}
}
