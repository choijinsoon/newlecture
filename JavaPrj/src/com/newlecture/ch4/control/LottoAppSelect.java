package com.newlecture.ch4.control;

import java.util.Random;

public class LottoAppSelect {

	public static void main(String[] args) {

		int size = 6;
		int[] lotto = new int[size];

		Random rand1 = new Random();

		for (int i = 0; i < size; i++) {
			lotto[i] = rand1.nextInt(45) + 1;
			System.out.printf("%d ", lotto[i]);
		}

		System.out.println();	
		
		
		// 선택 정렬
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
			System.out.printf("%d ", lotto[i]);
		}

		System.out.println();


		
		
		
//		int num1, num2, num3, num4, num5, num6, num7;
//		Random rand = new Random();
//		num1 = rand.nextInt(45) + 1;
//		num2 = rand.nextInt(45) + 1;
//		num3 = rand.nextInt(45) + 1;
//		num4 = rand.nextInt(45) + 1;
//		num5 = rand.nextInt(45) + 1;
//		num6 = rand.nextInt(45) + 1;
//		num7 = rand.nextInt(45) + 1;
//
//		System.out.print("┌─────────────────────────────────────┐\n");
//		System.out.print("│               로또 복권               │\n");
//		System.out.print("└─────────────────────────────────────┘\n");
//
//		System.out.printf("번호 : %d, %d, %d, %d, %d, %d  보너스 : %d\n", num1, num2, num3, num4, num5, num6, num7);

	}

}
