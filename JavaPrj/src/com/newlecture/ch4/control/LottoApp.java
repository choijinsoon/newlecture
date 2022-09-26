package com.newlecture.ch4.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Phaser;

public class LottoApp {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		int size = 6;
		int numSize = 6;
		int[] lotto = new int[size];
		int[] choose = new int[size];

		Random rand1 = new Random();

		EXIT: while (true) {
			System.out.print("┌────────────────────────────┐\n");
			System.out.print("│           로또 게임          │\n");
			System.out.print("└────────────────────────────┘\n");
			System.out.println("1. 번호 입력");
			System.out.println("2. 결과 확인");
			System.out.println("3. 번호 읽기");
			System.out.println("4. 번호 저장");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 > ");

			int menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.println("1 ~ 45 중 번호 7개를 입력하세요. ( Enter 로 구분)");
				for (int i = 0; i < size; i++) {
					choose[i] = scan.nextInt();
				}
				System.out.println("내가 입력한 번호");

				for (int i = 0; i < size; i++) {
					System.out.printf("%d ", choose[i]);
				}
				System.out.println();
				for (int i = 0; i < size; i++) {
					for (int j = i + 1; j < size; j++) {
						if (lotto[i] > lotto[j]) {
							int temp = lotto[i];
							lotto[i] = lotto[j];
							lotto[j] = temp;
						}
					}
//					System.out.printf("%d ", lotto[i]);
				}
				break;
			case 2:
				System.out.println("로또 결과 확인");
				System.out.println("로또 정답");
				for (int i = 0; i < size; i++) {
					lotto[i] = rand1.nextInt(numSize) + 1;
				}

				for (int i = 0; i < size; i++) {
					for (int j = i + 1; j < size; j++) {
						while (lotto[i] == lotto[j]) {
							int temp = lotto[i];
							lotto[i] = rand1.nextInt(numSize) + 1;
						}
						
						if (lotto[i] > lotto[j]) {
							int temp = lotto[i];
							lotto[i] = lotto[j];
							lotto[j] = temp;
						}
						
					}
					System.out.printf("%d ", lotto[i]);
				}

				System.out.println();
				System.out.println("내가 입력한 번호");
				for (int i = 0; i < size; i++) {
					for (int j = i + 1; j < size; j++) {
						if (choose[i] > choose[j]) {
							int temp = choose[i];
							choose[i] = choose[j];
							choose[j] = temp;
						}
					}
					System.out.printf("%d ", choose[i]);
				}
				System.out.println();
				System.out.println("정답 확인");

				for (int i = 0; i < size; i++)
					for (int j = 0; j < size; j++)
						if (choose[i] == lotto[j])
							System.out.printf("%d ", choose[i]);
				System.out.println();

				break;
			case 3:
				FileInputStream fis = new FileInputStream("res/lotto.txt");
				Scanner scan1 = new Scanner(fis);

				scan1.nextLine();
				for (int i = 0; i < size; i++)
					choose[i] = Integer.parseInt(scan1.nextLine());

				scan1.close();
				fis.close();
				System.out.println("번호 읽기 완료");

				break;
			case 4:
				FileOutputStream fout = new FileOutputStream("res/lotto.txt");
				PrintStream ps = new PrintStream(fout);

				ps.println("lotto");
				for (int i = 0; i < size; i++)
					ps.println(choose[i]);

				ps.close();
				fout.close();
				System.out.println("번호 저장 완료");

				break;
			case 5:
				break EXIT;

			}

		}

	}

}
