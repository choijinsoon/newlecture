package com.newlecture.part3.ch3;

public class ExamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExamPage page = new ExamPage();
		Exam exam = new Exam();
		Exam exam1 = new Exam(50,50,50);
		exam.print();
		exam1.print();
		System.out.println(exam);
		System.out.println(exam1);
		
		page.input();
		page.print();

	}

}
