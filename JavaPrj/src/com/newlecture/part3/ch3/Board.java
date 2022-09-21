package com.newlecture.part3.ch3;

public class Board {
	private Omok omok;
	private char[][] buf;
	public int WIDTH;
	public int HEIGHT;

	public Board() {
		WIDTH = 20;
		HEIGHT = 20;
	}

	public void get() {
		
	}

	public void repaint() {
		for (int y = 1; y <= HEIGHT; y++)
			for (int x = 1; x <= WIDTH; x++) {
				buf[y - 1][x - 1] = '┼';
				if (x == 1 && y == 1)
					buf[y - 1][x - 1] = '┌';
				else if (x == WIDTH && y == 1)
					buf[y - 1][x - 1] = '┐';
				else if (x == 1 && y == HEIGHT)
					buf[y - 1][x - 1] = '└';
				else if (x == WIDTH && y == HEIGHT)
					buf[y - 1][x - 1] = '┘';
				else if (y == 1)
					buf[y - 1][x - 1] = '┬';
				else if (y == HEIGHT)
					buf[y - 1][x - 1] = '┴';
				else if (x == 1)
					buf[y - 1][x - 1] = '├';
				else if (x == WIDTH)
					buf[y - 1][x - 1] = '┤';

			}
	}

	public void put(Omok omok) {

	}

}
