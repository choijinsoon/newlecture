package com.newlecture.test;

import java.util.Scanner;

public class OmokConsole {
	private Board board;
	private int turn;

	public OmokConsole() {
		board = new Board();
		turn = 0;
	}

	public void print() {
		board.repaint();
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 20; x++)
				System.out.printf("%c", board.get(x, y));
			System.out.println();
		}
		System.out.println();
	}

	public void inputOmok() {
		Scanner scan = new Scanner(System.in);

		System.out.print("(x y) : ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		int color = turn;

		if (turn == 0)
			turn = 1;
		else if (turn == 1)
			turn = 0;

		Omok omok = new Omok(x, y, color);

		board.put(omok);

	}

	public void rollbackOmok() {
		board.rollback();
		
	}

}
