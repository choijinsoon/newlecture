package com.newlecture.homwork;

import java.util.Scanner;

public class Coordinates {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("좌표 위치 입력");
			System.out.print("x값 :");
			int x1 = scan.nextInt();
			System.out.print("y값 :");
			int y1 = scan.nextInt();

			System.out.println("┌ㅡㅡㅡㅡㅡㅡㅡㅡㅡ→ x");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("↓");
			System.out.println("y");
			
			for (int y2 = 0; y2 < y1; y2++) {
				System.out.println();
				for (int x2 = 0; x2 < x1; x2++)
					System.out.print(" ");
			}
			System.out.println("*");
			System.out.printf("좌표: (%d,%d)\n", x1, y1);
		}

	}
}
