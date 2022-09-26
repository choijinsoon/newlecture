package com.newlecture.part3.ch3;

public class ExamPage {
	
	// ExamPage 에 Exam 를 Has A 상속 했다.
	// ExamPage 를 구성하는 요소로 자리하고 있는 캡슐을 우리는 Has A 했다고 말한다.
	/*
	 * 1. Composition Has A 관계 : 일체형 ExamPage 에서 Exam exam = new Exam()
	 * 1. Association Has A 관계 : 결합형 main 에서 page.setExam(exam)
	 * 1. Aggregation Has A 관계 : 집합형 ExamPage 에서 Exam[] exam = new Exam[10]
	 */
	private Exam exam = new Exam();
	//private Exam[] exam = new Exam[10]; // 집합형
	

	public void input() {
		// TODO Auto-generated method stub
		
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}
