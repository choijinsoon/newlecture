package com.newlecture.ch3.fo;

public class ForReport1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int y = 1; y <= 10; y++) {
			for (int x = 1; x <= 10; x++) {
//				System.out.printf("%d%d ",x,y);
				if (x<=y && x>10-y)
					System.out.printf("%c", '●');
				else if (x == 1)
					System.out.printf("%c", '○');
				else
					System.out.printf("%c", '┼');

			}

			System.out.println();
		}
	}

}