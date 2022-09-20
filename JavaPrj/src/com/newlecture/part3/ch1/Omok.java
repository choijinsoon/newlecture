package com.newlecture.part3.ch1;

import java.util.Scanner;

public class Omok {
	private int x;
	private int y;
	private char color;

	public void input() {
		color = '●';
		Scanner scan = new Scanner(System.in);
		System.out.printf("%c 오목 위치를 입력하세요 ( x, y 값 )\n", color);
		System.out.print("x y >");
		x = Integer.parseInt(scan.next());
		y = Integer.parseInt(scan.next());

		
	}
	
	public void xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
