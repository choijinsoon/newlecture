package com.newlecture.ch4.control;

import java.util.Random;
import java.util.Scanner;

public class TestConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		int size = 6;
		int[] lotto = new int[size];
		int[] choose = new int[size];

		Random rand1 = new Random();
		
		System.out.println("번호 7개를 입력하세요. ( Enter 로 구분)");
		for(int i = 0; i<size;i++) {
			choose[i] = scan.nextInt();
		}
		

		System.out.println("입력한 값 확인");
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (choose[i] > choose[j]) {
					int temp = choose[i];
					choose[i] = choose[j];	
					choose[j] = temp;
				}
			}
			System.out.printf("%d ", choose[i]);
		}

	}

}
