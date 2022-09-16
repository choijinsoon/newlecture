package com.newlecture.homwork;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		//랜덤 함수 맞추기
		Random rand1 = new Random();
		int answer = rand1.nextInt(50) + 1;
		int chance = 5;
		int i = 0;

		Scanner scan = new Scanner(System.in);

		while(i<chance) {
			System.out.print("숫자 입력: ");
			int num = scan.nextInt();
			if (num == answer) {
				System.out.printf("%d 정답입니다.\n", num);
				break;
			} else {
				System.out.printf("%d 오답입니다.\n", num);
			}

			if (num >= answer) {
				System.out.printf("%d 보다 낮습니다.\n", num);
			} else if (num <= answer) {
				System.out.printf("%d 보다 높습니다.\n", num);
			}
			i++;
		}

	}

}
