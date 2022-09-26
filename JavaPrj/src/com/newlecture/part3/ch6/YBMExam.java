package com.newlecture.part3.ch6;

public class YBMExam extends Exam{
	private int com;
	
	public YBMExam() {
		super();
	}

	public int getCom() {
		return com;
	}
	
	public int total() {
		int total = super.total() + com;
		return total;
	}

}
