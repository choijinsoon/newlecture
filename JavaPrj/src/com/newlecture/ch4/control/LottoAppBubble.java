package com.newlecture.ch4.control;

import java.io.IOException;
import java.util.Random;

public class LottoAppBubble {

	public static void main(String[] args) throws IOException {

		int x; // 공간만 만드는게 선언
		x=3; // 정의
		int y = 3; //선언 + 정의
		int[] z = new int[3]; // 선언
		
		
		int size = 6;
		int[] lotto = new int[size];

		Random rand1 = new Random();

		for (int i = 0; i < size; i++) {
			lotto[i] = rand1.nextInt(45) + 1;
			System.out.printf("%d ", lotto[i]);
		}

		System.out.println();

		// 버블 정렬
		for (int j = 0; j < size - 1; j++) {
			for (int i = 0; i < size - 1 - j; i++) {
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", lotto[i]);
		}

	}

}
