package com.newlecture.homwork;

import java.util.Scanner;

public class NineNine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		System.out.print("단 입력 :");
		int dan = scan.nextInt();
		
		System.out.printf("=========%d 단========\n", dan);
		for (int j = 1; j < 10; j++) {
			System.out.printf("%d * %d = %d", dan, j, dan*j);
			System.out.println();
		}
		System.out.println();
		}
		
		//구구단
//		for (int i = 1; i < 10; i++) {
//			System.out.printf("=========%d 단========\n", i);
//			for (int j = 1; j < 10; j++) {
//				System.out.printf("%d * %d = %d", i, j, i*j);
//				System.out.println();
//			}
//			System.out.println();
//		}
	}
}
