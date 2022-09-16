package com.newlecture.homwork;

import java.util.Random;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();

		int studentCount = 6;
		int[] seats = { 1, 2, 3, 4, 5, 6 };
		String[] nameSeats = new String[studentCount];

		int[] randomValue = new int[studentCount];
		String[][] students = { { "1", "김1" }, { "2", "이1" }, { "3", "박1" }, { "4", "김2" }, { "5", "이2" },
				{ "6", "박2" } };

		// randomValue[] 랜덤 배열 생성 후 students[] 에 대입
		for (int i = 0; i < studentCount; i++) {
			randomValue[i] = random.nextInt(studentCount) + 1;
			for (int j = 0; j < i; j++)
				if (randomValue[i] == randomValue[j]) {
					i--;
				}
			students[i][0] = Integer.toString(randomValue[i]);
		}

		// seats[] 고정 값이 students[0]과 일치하면 nameSeat[] 에 저장  
		for (int j = 0; j < studentCount; j++) {
			for (int i = 0; i < studentCount; i++) {
				if (seats[j] == Integer.parseInt(students[i][0])) {
					nameSeats[j] = students[i][1];
				}
			}

		}

		for (int i = 0; i < studentCount; i++) {
			System.out.printf("%5s", nameSeats[i]);
			if((i+1)%3==0)
				System.out.println();
		}

		// student[0]이 seats 좌석과 같다면 nameSeats에 이름 저장
//		for (int i = 0; i < 3; i++) 
//			if(seats[0] == Integer.parseInt(students[i][0])) {
//				nameSeats[0] = students[i][1];
//			}
//	
//		for (int i = 0; i < 3; i++) 
//			System.out.println(nameSeats[i]);

//		
//		
//		for (int i = 0; i < 3; i++) {
//			students[i] = randomValue[i];
//			System.out.println(randomValue[i]);
//			if(randomValue[i] == seats[i]) {
//			}
//		}
	}

}
