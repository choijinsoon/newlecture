package com.newlecture.part3.ch5;

public class ExamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exam exam = new Exam();
		Exam exam1 = new Exam(50, 50, 50);
		exam.print();
		exam1.print();
		System.out.println(exam);
		System.out.println(exam1);

		ExamPage page = new ExamPage(exam1);

		exam1.setKor(20);
		System.out.println(exam1.getKor());

		page.input();
		page.print();

	}

}
