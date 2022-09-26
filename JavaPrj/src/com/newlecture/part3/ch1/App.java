package com.newlecture.part3.ch1;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board board = new Board();
		Omok omok = new Omok();

		// 오목판 초기화
		board.init();
		// 오목판을 출력한다.
		board.print();
		// 사용자로부터 오목을 입력 받는다.
		omok.input();
		// 오목판에 오목을 둔다.
		board.put(omok);
		// 오목판을 출력한다.
		board.print();
		

	}

}
