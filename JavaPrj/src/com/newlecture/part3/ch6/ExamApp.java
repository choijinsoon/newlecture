package com.newlecture.part3.ch6;

import java.awt.Frame;

public class ExamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		YBMExam exam = new YBMExam();

		System.out.println(exam.getKor());
		System.out.println(exam.getCom());

		GameFrame win = new GameFrame();
		win.setSize(500, 400);
		win.setVisible(true);

	}

}
