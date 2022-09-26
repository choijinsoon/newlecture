package com.newlecture.part3.ch4;

import java.util.Scanner;

public class BoardConsole {
	private Board board;
	private int turn;

	public BoardConsole() {
		board = new Board();
		turn = 0; // 검은색
	}

	public void print() {
		board.repaint(); //리셋 후 여태까지 한것 다시 출력
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
		// omok.setX(x);
		// omok.setX(y);
		// omok.setX(color);

		board.put(omok);

	}

	public void rollbackOmok() {
		board.rollback();

	}

}
