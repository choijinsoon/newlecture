package com.newlecture.ch3.fo;

public class ForReport2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int y = 1; y <= 12; y++) {
			for (int x = 1; x <= 12; x++) {
				if (y == 1) {
					if (x == 1)
						System.out.printf("%c", '┌');
					else if (x == 12)
						System.out.printf("%c", '┐');
					else
						System.out.printf("%c", '┬');
				} else if (y == 12){
					if (x == 1)
						System.out.printf("%c", '└');
					else if (x == 12)
						System.out.printf("%c", '┘');
					else
						System.out.printf("%c", '┴');
				}
				else if (x == 1)
					System.out.printf("%c", '├');
				else if (x == 12)
					System.out.printf("%c", '┤');
				else
					System.out.printf("%c", '┼');

			}

			System.out.println();
		}
	}

}
