package com.newlecture.test;

import java.util.Scanner;

public class Board { 
	private char[][] buf;
	private Omok[] omoks;
	private int height;
	private int width;
	private int index;
	int x;

	public Board() {
		height = 20;
		width = 20;
		buf = new char[height][width];
		omoks = new Omok[height * width];
		index = 0;

		init();
	}

	private void init() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				buf[y][x] = '┼';
		}
	}

	public char get(int x, int y) {
		return buf[y][x];
	}

	public void put(Omok omok) {
		int x = omok.getX();
		int y = omok.getY();
		int color = omok.getColor();

		omoks[index] = omok;
		index++;
	}

	public void rollback() {
		index--;
		omoks[index] = null;
	}

	public void repaint() {
		init();
		for (int i = 0; i < index; i++) {
			int x = omoks[i].getX();
			int y = omoks[i].getY();
			int color = omoks[i].getColor();
 
			if (color == 0)
				buf[y][x] = '●';
			else if (color == 1)
				buf[y][x] = '○';
		}
	}

}
