package com.newlecture.part3.ch5;

import java.util.Scanner;

public class LottoConsole {
	private Lotto lotto;

	public LottoConsole() {
		lotto = new Lotto();
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            로또 입력          │\n");
		System.out.print("└─────────────────────────────┘\n");
		System.out.print("로또 번호 6개를 입력하세요> ");
		for (int i = 0; i < 6; i++)
			lotto.set(i, scan.nextInt());

	}

	public void print() {
		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            로또 출력          │\n");
		System.out.print("└─────────────────────────────┘\n");
		System.out.println("로또 번호 6개를 출력합니다");
		lotto.sort();
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto.get(i));

	}
}
