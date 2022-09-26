package com.newlecture.ch3.fo;

public class ForTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int n = 1, c = 1; n <= 100; n++) {

			int an = 1 + (c - 1) * 10;

			if (n == an) {
				System.out.printf("%c", '○');
				c++;
			} else
				System.out.printf("%c", '┼');

			if (n % 10 == 0)
				System.out.print('\n');
		}

		// ==============================

		System.out.println("=====================");
		for (int y = 1; y <= 10; y++) {
			for (int x = 1; x <= 10; x++) {
				if (x == 1)
					System.out.printf("%c", '○');
				else
					System.out.printf("%c", '┼');
			}
			System.out.println();
		}

		// ● ○
		System.out.println("=====================");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 9 - i)
					System.out.printf("%c", '●');
				else if (j == 0)
					System.out.printf("%c", '○');
				else
					System.out.printf("%c", '┼');

			}

			System.out.println();
		}

		//report1
		System.out.println("=====================");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j == i && i > (10 - j) || j < i && i > (10 - j))
					System.out.printf("%c", '●');
				else if (j == 1)
					System.out.printf("%c", '○');
				else
					System.out.printf("%c", '┼');

			}

			System.out.println();
		}
	}
}
