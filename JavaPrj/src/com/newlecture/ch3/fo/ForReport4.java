package com.newlecture.ch3.fo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ForReport4 {

	public static void main(String[] args) throws IOException {

		int[] a = new int[3];
		for(int i=0;i<3;i++) {
			a[i] = i;
			System.out.printf("%d ", a[i]);
		}
		
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("좌표 위치 입력");
			System.out.println("'0' 입력 시 종료");
			System.out.print("순번 입력 (1/2) :");

			int user = scan.nextInt();
			System.out.print("x값 :");
			int x1 = scan.nextInt();
			System.out.print("y값 :");
			int y1 = scan.nextInt();

			if (x1 > 0 && y1 > 0) {
				for (int y = 1; y <= 12; y++) {
					for (int x = 1; x <= 12; x++) {
						if (user == 1 && x == x1 && y == y1)
							System.out.print("○");
						else if (user == 2 && x == x1 && y == y1)
							System.out.print("●");
						
						
						
						
						else {
							if (y == 1) {
								if (x == 1)
									System.out.printf("%c", '┌');
								else if (x == 12)
									System.out.printf("%c", '┐');
								else
									System.out.printf("%c", '┬');
							} else if (y == 12) {
								if (x == 1)
									System.out.printf("%c", '└');
								else if (x == 12)
									System.out.printf("%c", '┘');
								else
									System.out.printf("%c", '┴');
							} else if (x == 1)
								System.out.printf("%c", '├');
							else if (x == 12)
								System.out.printf("%c", '┤');
							else
								System.out.printf("%c", '┼');
						}
					}

					System.out.println();
				}
			} else {
				System.out.println("다시 입력하세요");
			}

		}
	}

}
