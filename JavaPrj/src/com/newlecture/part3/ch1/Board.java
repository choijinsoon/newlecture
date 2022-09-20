package com.newlecture.part3.ch1;

public class Board {
	private int width;
	private int height;
	private char[][] buf;

	public void init() {
		width = 10;
		height = 10;
		buf = new char[height][width];

		for (int y = 1; y <= height; y++)
			for (int x = 1; x <= width; x++) {
				buf[y - 1][x - 1] = '┼';
				if (x == 1 && y == 1)
					buf[y - 1][x - 1] = '┌';
				else if (x == width && y == 1)
					buf[y - 1][x - 1] = '┐';
				else if (x == 1 && y == height)
					buf[y - 1][x - 1] = '└';
				else if (x == width && y == height)
					buf[y - 1][x - 1] = '┘';
				else if (y == 1)
					buf[y - 1][x - 1] = '┬';
				else if (y == height)
					buf[y - 1][x - 1] = '┴';
				else if (x == 1)
					buf[y - 1][x - 1] = '├';
				else if (x == width)
					buf[y - 1][x - 1] = '┤';

			}

	}

	public void print() {

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				System.out.printf("%c", buf[y - 1][x - 1]);
			System.out.println();
		}
	}

	public void put(Omok omok) {
		omok.xy(1, 1);
		omok = new Omok();
		buf[omok.y - 1][omok.x - 1] = omok.color;

	}

}
