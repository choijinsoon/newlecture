package com.newlecture.part3.ch4;

public class Board {
	private char[][] buf;
	private Omok[] omoks;
	private int index;

	public Board() {
		buf = new char[20][20];
		omoks = new Omok[400];
		index = 0;

		init();
	}

	public void init() {
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 20; x++)
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

//		if (color == 0)
//			buf[y-1][x-1] = '●';
//		else if (color == 1)
//			buf[y-1][x-1] = '○';
		omoks[index] = omok; // omoks[index]에 omok를 저장하는데 omok은 x,y,color의 정보를 가지고 있다. (2중 배열의 느낌?)
		index++;

	}

	public void rollback() {
		index--;
		omoks[index] = null;

	}

	public void repaint() {
		init();
		for (int i = 0; i < index; i++) { // omoks 에서 index 까지 저장된 omok 의 x,y,color 정보를 불러와서 buf[y][x]에 대입
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
