package com.newlecture.test;

public class OmokApp {

	public static void main(String[] args) {

		OmokConsole console = new OmokConsole();
		
		console.print();
		console.inputOmok();
		console.print();
		console.inputOmok();
		console.print();
		console.rollbackOmok();
		console.print();
		console.rollbackOmok();
		console.print();
		console.inputOmok();
		console.print();
	}

}
