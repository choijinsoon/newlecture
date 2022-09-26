package com.newlecture.homwork;
import java.util.Random;

public class Lotto {

	
	public static void main(String[] args) {
		
		int num1, num2, num3, num4, num5, num6, num7;
		Random rand = new Random();
		num1 = rand.nextInt(45)+1;
		num2 = rand.nextInt(45)+1;
		num3 = rand.nextInt(45)+1;
		num4 = rand.nextInt(45)+1;
		num5 = rand.nextInt(45)+1;
		num6 = rand.nextInt(45)+1;
		num7 = rand.nextInt(45)+1;
		
		System.out.print("┌─────────────────────────────────────┐\n");
		System.out.print("│               로또 복권               │\n");
		System.out.print("└─────────────────────────────────────┘\n");
		
		System.out.printf("번호 : %d, %d, %d, %d, %d, %d  보너스 : %d\n", num1, num2, num3, num4, num5, num6, num7);

	}

}
