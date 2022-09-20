package com.newlecture.part3.ch2;

public class ExamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exam exam = new Exam();
		
		// 메뉴 선택
		exam.inputMenu();
		
		// 성적 입력하기
		exam.input();

		// 성적 출력하기
		exam.print();

	}

}
