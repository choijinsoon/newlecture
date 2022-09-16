package com.newlecture.ch4.control;


public class LottoApp2 {

	public static void main(String[] args)  {

		int[] lotto1 = { 1, 2, 3, 4, 5, 6 };
		int[] lotto2 = { 6, 7, 8, 9, 10, 11 };
		int[] lotto3 = { 11, 12, 13, 14, 15, 16 };

		int[][] lottos = new int[3][];
		lottos[0] = lotto1;
		lottos[1] = lotto2;
		lottos[2] = lotto3;

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 6; i++)
				System.out.printf("%d ", lottos[j][i]);
			System.out.println();
		}
		System.out.println();

		int[] temp = lottos[0];
		lottos[0] = lottos[1];
		lottos[1] = temp;
		
		
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 6; i++)
				System.out.printf("%d ", lottos[j][i]);
			System.out.println();
		}

	}

}
